package com.example;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 */
public class WebCrawlerAppTest {
    @Test
    public void search() throws Exception {
        WebCrawlerApp webCrawlerApp = new WebCrawlerApp();
        Map<String, List<String>> pageLinksMap = webCrawlerApp.search("http://wiprodigital.com");
        assertThat(pageLinksMap.get("http://wiprodigital.com").size(), not(0));
    }
}