package com.example;

import org.junit.Test;

/**
 */
public class WebCrawlerTest {
    @Test
    public void search() throws Exception {
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.search("http://wiprodigital.com");
    }
}