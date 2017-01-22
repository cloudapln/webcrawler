package com.example.sitemap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * display pages visited as json response
 */
public class SiteMapGenerator {

    public String generateJosnSiteMap(Map<String, List<String>> pageLinksMap) {
        JSONObject jsonObject = new JSONObject();

        for (Map.Entry<String, List<String>> pageLinks : pageLinksMap.entrySet()) {
            List<String> pageLinksList = pageLinks.getValue();
            JSONArray list = new JSONArray();
            for (String pageLink : pageLinksList) {
                list.put(pageLink);
            }
            jsonObject.put(pageLinks.getKey(), list);

        }
        return jsonObject.toString(3);
    }

}
