package com.example;

import java.net.MalformedURLException;

/**
 */
public class WebCrawlerApplication {

    public static void main(String args[]) throws MalformedURLException {
        WebCrawlerApp webCrawlerApp = new WebCrawlerApp();
        String siteMap = webCrawlerApp.generateSiteMap("http://wiprodigital.com");
        System.out.println(siteMap);
    }
}
