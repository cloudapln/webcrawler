package com.example;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.UrlChecker.domainName;
import static com.example.UrlChecker.isInternalUrl;

/**
 * Main class to crawling for given url
 */
public class WebCrawler {
    // Map to store links found on respective page

    public Map<String, List<String>> search(String searchUrl) throws MalformedURLException {
        String domainName = domainName(searchUrl);
        Map<String, List<String>> pageLinksMap = new HashMap<>();
        PageParser pageParser = new PageParser();
        if (isInternalUrl(searchUrl, domainName)) {
            //parse page, get links list
            List<String> linksOnPage = pageParser.parse(searchUrl);
            //add links list to map
            pageLinksMap.put(searchUrl, linksOnPage);
        }
        return pageLinksMap;
    }


}
