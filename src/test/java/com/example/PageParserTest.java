package com.example;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 */
public class PageParserTest {
    @Test
    public void shouldParseHtmlPage() throws Exception {
        PageParser unitUnderTest = new PageParser();
        List<String> linksonPage = unitUnderTest.parse("http://wiprodigital.com");
        assertThat(linksonPage.size(), not(0));
    }
}