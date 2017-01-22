package com.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class WebCrawlerAppTest {
    private static Logger LOGGER = LoggerFactory.getLogger(WebCrawlerAppTest.class);

    @Test
    public void generateSiteMap() throws Exception {
        WebCrawlerApp webCrawlerApp = new WebCrawlerApp();
        String siteMap = webCrawlerApp.generateSiteMap("http://wiprodigital.com");
        LOGGER.info(siteMap);
    }
}