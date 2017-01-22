package com.example;

import java.net.MalformedURLException;
import java.util.*;

import static com.example.UrlChecker.domainName;
import static com.example.UrlChecker.isInternalUrl;

/**
 * Main class to crawling for given url and cascade links within pages
 */
public class WebCrawler {
    private List<String> pagesToVisit = new LinkedList<String>();
    private Set<String> pagesVisited = new HashSet<String>();


    public Map<String, List<String>> search(String searchUrl) throws MalformedURLException {
        String domainName = domainName(searchUrl);
        // Map to store links found on respective page
        Map<String, List<String>> pageLinksMap = new HashMap<>();
        String currentUrl;

        PageParser pageParser = new PageParser();
        if (this.pagesToVisit.isEmpty()) {
            currentUrl = searchUrl;
            this.pagesVisited.add(searchUrl);
        } else {
            currentUrl = this.urlToBeCrawled();
        }
        if (isInternalUrl(searchUrl, domainName)) {
            //parse page, get links list
            List<String> linksOnPage = pageParser.parse(searchUrl);
            //add links list to map
            pageLinksMap.put(searchUrl, linksOnPage);
            this.pagesToVisit.addAll(linksOnPage);
        }
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
