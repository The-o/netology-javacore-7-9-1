package ru.netology.pyas;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import ru.netology.pyas.fact.Fact;

public class Main {

    public static final String URL = "https://cat-fact.herokuapp.com/facts";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        HttpGet request = new HttpGet(URL);
        try (
            CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(
                    RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build()
                )
                .build();
            CloseableHttpResponse response = client.execute(request)
        ) {
            List<Fact> facts = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Fact>>(){});

            facts.stream().forEach(System.out::println);
        } catch(IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
