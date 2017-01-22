package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

/**
 */
public class WebCrawlerApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(WebCrawlerApplication.class);

    public static void main(String args[]) throws MalformedURLException {
        WebCrawlerApp webCrawlerApp = new WebCrawlerApp();
        String siteMap = webCrawlerApp.generateSiteMap("http://wiprodigital.com");
        LOGGER.info(siteMap);
    }
}
