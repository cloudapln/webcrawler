package com.example;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlChecker {
    /**
     *  Checks if it is internal url
     *
     * @param urlToBeChecked url
     * @param domainName domainName
     * @return boolean
     * @throws MalformedURLException
     */
    public static boolean isInternalUrl(String urlToBeChecked, String domainName) throws MalformedURLException {
        URL domainUrl = new URL(urlToBeChecked);
        return domainUrl.getHost().equalsIgnoreCase(domainName);
    }

    /**
     * Gets domainName
     *
     * @param searchUrl url
     * @return String domainName
     * @throws MalformedURLException
     */
    public static String domainName(String searchUrl) throws MalformedURLException {
        URL domainUrl = new URL(searchUrl);
        return domainUrl.getHost();
    }

}
