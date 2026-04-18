package com.forge_miniatures.service.client;

import com.forge_miniatures.dto.CollectionResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CollectionAPIClient {
    private final RestTemplate restTemplate;

    @Value("${collection.api.url}")
    private String collectionAPIUrl;

    public CollectionAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CollectionResponseDTO getCollection(Long userId, Long collectionId){
        String url = this.collectionAPIUrl + "/api/collections/" + userId + "/" + collectionId;

        return restTemplate.getForObject(url, CollectionResponseDTO.class);
    }


}
