package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;

/**
 * This class parses html page to check for links
 * within page.
 */
public class PageParser {
    private static Logger LOGGER = LoggerFactory.getLogger(PageParser.class);

    // using chrome 41 user agent, so web server think it's not robot
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

    /**
     * This uses  {@link org.jsoup.Jsoup} to make HTTP request,
     * parses HTML page, checks all links on page.
     *
     * @param pageUrl
     * @return List<String> linksOnPage
     */
    public List<String> parse(String pageUrl) {
        List<String> linksOnPage = new LinkedList<String>();
        Document htmlDocument;
        try {
            Connection connection = Jsoup.connect(pageUrl).userAgent(USER_AGENT);
            htmlDocument = connection.get();
            if (connection.response().statusCode() == 200)
                if (!connection.response().contentType().contains("text/html")) {
                    LOGGER.error("Not HTML Page");
                    return linksOnPage;
                }
            Elements linkElementsOnPage = htmlDocument.select("a[href]");
            for (Element linkElement : linkElementsOnPage) {
                linksOnPage.add(linkElement.absUrl("href"));
            }
            return linksOnPage;
        } catch (IOException exception) {
            LOGGER.error(format("Error while parsing page %s", pageUrl));
            return linksOnPage;
        }
    }
}
