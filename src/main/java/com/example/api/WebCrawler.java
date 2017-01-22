package com.example.api;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

/**
 * Contract defined for crawling of given url and cascade links within pages
 */
public interface WebCrawler {

    /**
     * Generates sitemap JSON string for searchurl visited by WebCrawler
     *
     * @param searchUrl
     * @return String
     */
    public String generateSiteMap(String searchUrl) throws MalformedURLException;

    /**
     * Generates sitemap for searchurl visited by WebCrawler
     *
     * @param searchUrl
     * @return Map<String, List<String>>
     */
    public Map<String, List<String>> search(String searchUrl) throws MalformedURLException;
}
