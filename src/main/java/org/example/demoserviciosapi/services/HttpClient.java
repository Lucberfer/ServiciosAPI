package org.example.demoserviciosapi.services;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * A simple HTTP client service that fetches data from a given URI.
 */
public class HttpClient {

    /**
     * Fetches data from a specified URI using an HTTP GET request.
     *
     * @param uri The target URL to fetch data from.
     * @return The response body as a string, or an error message if the request fails.
     */
    public String fetchData(String uri) {
        try {
            // Create a new HTTP client instance
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

            // Build an HTTP GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri)) // Set target URI
                    .GET() // Specify the GET method
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Return the response body
            return response.body();
        } catch (Exception e) {
            // Return an error message in case of an exception
            return "Error while making the request: " + e.getMessage();
        }
    }
}
