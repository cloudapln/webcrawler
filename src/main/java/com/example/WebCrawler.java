package com.example;

import java.net.MalformedURLException;
import java.util.*;

import static com.example.UrlChecker.domainName;
import static com.example.UrlChecker.isInternalUrl;

/**
 * Main class to crawling for given url
 */
public class WebCrawler {
    private List<String> pagesToVisit = new LinkedList<String>();
    
    public Map<String, List<String>> search(String searchUrl) throws MalformedURLException {
        String domainName = domainName(searchUrl);
        // Map to store links found on respective page
        Map<String, List<String>> pageLinksMap = new HashMap<>();
        PageParser pageParser = new PageParser();
        if (isInternalUrl(searchUrl, domainName)) {
            //parse page, get links list
            List<String> linksOnPage = pageParser.parse(searchUrl);
            //add links list to map
            pageLinksMap.put(searchUrl, linksOnPage);
            this.pagesToVisit.addAll(linksOnPage);
        }
        return pageLinksMap;
    }


}
