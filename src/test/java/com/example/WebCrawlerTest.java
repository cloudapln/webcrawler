package com.example;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 */
public class WebCrawlerTest {
    @Test
    public void search() throws Exception {
        WebCrawler webCrawler = new WebCrawler(urlChecker);
        Map<String, List<String>> pageLinksMap = webCrawler.search("http://wiprodigital.com");
        assertThat(pageLinksMap.get("http://wiprodigital.com").size(), not(0));
    }
}