package com.modulo7.crawler.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 6/20/2015.
 *
 * This class is used to use to google API to get a set of png and jpg files
 * that is to be used by basic images crawler to crawl out relevant
 * sheet music
 *
 */
public class GoogleImageGetQuery {

    // Set of image URLs acquired as a part of the
    private Set<String> imageURLs;

    public GoogleImageGetQuery() {
        imageURLs = new HashSet<>();
    }

    public void executeImageSearch(String query) {
        try {
            // Convert query to lowercase
            query = query.toLowerCase();

            query = query.replaceAll("\\s", "+");

            for (int iter = 0; iter < 100; iter++) {
                final String GOOGLE_IMAGE_SEARCH =
                        "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&start="+ iter * 8 + "&q=";

                URL url = new URL(GOOGLE_IMAGE_SEARCH + query);
                URLConnection connection = url.openConnection();

                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                JSONObject json = new JSONObject(builder.toString());
                try {
                    JSONObject responseData = json.getJSONObject("responseData");
                    if (responseData != null) {
                        JSONArray imageObjects = responseData.getJSONArray("results");
                        for (int i = 0; i < imageObjects.length(); i++) {
                            JSONObject imageObject = imageObjects.getJSONObject(i);
                            String imageUrl = imageObject.getString("url");
                            imageURLs.add(imageUrl);
                        }
                    }
                } catch (JSONException e) {
                    // In case of bad json parsing, dont crash
                    continue;
                }
            }
        } catch (IOException e) {
           // In case of IO errors dont crash(TODO : Log this), just pass along
        }
    }

    /**
     * Getter for the image URLS
     * @return
     */
    public Set<String> getImageURLs() {
        return imageURLs;
    }

    public static void main(String args[]) throws IOException {
        GoogleImageGetQuery query = new GoogleImageGetQuery();

        // TODO : Add additional check on query type to contain the keyword sheet music or some variant of the same
        query.executeImageSearch("led zepplin sheet music");
    }
}
