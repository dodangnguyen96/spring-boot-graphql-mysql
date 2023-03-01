package com.bezkoder.springgraphql.mysql.controllers;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class SampleGraphQLApiController {

    @PostMapping(value = "/api/grapql")
    public String allUserProfiles(@RequestBody String queryVal) throws IOException, URISyntaxException {

        String url = "http://localhost:8080/apis/graphql";
        String requestBody = "\"query\": \"{\\r\\nfindAllAuthors{\\r\\nid\\r\\nname\\r\\nage\\r\\n}\\r\\n\\r\\n}\\r\\n\\r\\n\"";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        URI uri = new URIBuilder(request.getUri())
                .build();
        HttpEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        request.setUri(uri);
        request.setEntity(requestEntity);
        return client.execute(request).toString();
    }

    }
