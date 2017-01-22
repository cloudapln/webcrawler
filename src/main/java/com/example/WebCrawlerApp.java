package com.example;

import com.example.api.WebCrawler;
import com.example.parser.PageParser;
import com.example.sitemap.SiteMapGenerator;

import java.net.MalformedURLException;
import java.util.*;

import static com.example.util.UrlChecker.domainName;
import static com.example.util.UrlChecker.isInternalUrl;

/**
 * Main class to crawling for given url and cascade links within pages
 */
public class WebCrawlerApp implements WebCrawler {
    private final SiteMapGenerator siteMapGenerator;
    private List<String> pagesToVisit = new LinkedList<String>();
    private Set<String> pagesVisited = new HashSet<String>();

    public WebCrawlerApp() {
        this.siteMapGenerator = new SiteMapGenerator();
    }

    public String generateSiteMap(String searchUrl) throws MalformedURLException {
        Map<String, List<String>> pageLinksMap = search(searchUrl);
        return siteMapGenerator.generateJosnSiteMap(pageLinksMap);
    }

    public Map<String, List<String>> search(String searchUrl) throws MalformedURLException {
        String domainName = domainName(searchUrl);
        // Map to store links found on respective page
        Map<String, List<String>> pageLinksMap = new HashMap<>();
        do {
            String currentUrl;
            PageParser pageParser = new PageParser();
            if (this.pagesToVisit.isEmpty()) {
                currentUrl = searchUrl;
                this.pagesVisited.add(searchUrl);
            } else {
                currentUrl = this.urlToBeCrawled();
            }
            if (isInternalUrl(currentUrl, domainName)) {
                //parse page, get links list
                List<String> linksOnPage = pageParser.parse(currentUrl);
                //add links list to map
                pageLinksMap.put(currentUrl, linksOnPage);
                this.pagesToVisit.addAll(linksOnPage);
            }
        } while (this.pagesVisited.size() < 300);
        return pageLinksMap;
    }

    /**
     * This method returns the next urlToBeCrawled
     *
     * @return nextUrlToBeCrawled
     */
    private String urlToBeCrawled() {
        String nextUrlToBeCrawled;
        do {
            nextUrlToBeCrawled = this.pagesToVisit.remove(0);
        } while (this.pagesVisited.contains(nextUrlToBeCrawled));
        this.pagesVisited.add(nextUrlToBeCrawled);
        return nextUrlToBeCrawled;
    }

}
