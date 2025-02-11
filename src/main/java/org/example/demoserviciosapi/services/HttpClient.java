package org.example.demoserviciosapi.services;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {
    public String fetchData(String uri) {
        try {
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
