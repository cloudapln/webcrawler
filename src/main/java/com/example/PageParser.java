package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * This class parses html page to check for links
 * within page.
 */
public class PageParser {

    /**
     * This uses  {@link org.jsoup.Jsoup} to make HTTP request,
     * parses HTML page, checks all links on page.
     *
     * @param pageUrl
     * @return List<String> linksOnPage
     */
    public List<String> parse(String pageUrl) {
        List<String> linksOnPage = new LinkedList<String>();
        return linksOnPage;
    }
}
