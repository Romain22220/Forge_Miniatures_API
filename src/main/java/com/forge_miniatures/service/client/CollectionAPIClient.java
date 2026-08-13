package com.forge_miniatures.service.client;

import com.forge_miniatures.dto.collection.CollectionDTO;
import com.forge_miniatures.dto.collection.CollectionResponseDTO;
import com.forge_miniatures.dto.collection.CreateCollectionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
public class CollectionAPIClient {
    private final RestTemplate restTemplate;
    @Value("${collection.api.url}")
    private String collectionAPIUrl;

    @Value("${collection.api.internal-secret}")
    private String internalSecret;

    public CollectionAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CollectionResponseDTO getCollection(Long userId, Long collectionId){
        String url = this.collectionAPIUrl + "/api/collections/" + userId + "/" + collectionId;

        return restTemplate.getForObject(url, CollectionResponseDTO.class);
    }

    public List<CollectionResponseDTO> getAllCollections(Long userId) {

        String url = collectionAPIUrl + "/api/collections/me/all";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Internal-Secret", internalSecret);
        headers.set("X-User-Id", userId.toString());
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<CollectionResponseDTO[]> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        CollectionResponseDTO[].class
                );

        return Arrays.asList(response.getBody());
    }

    public CollectionDTO createCollection(Long userId, CreateCollectionDTO collectionDTO) {

        String url = collectionAPIUrl + "/api/collections";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-User-Id", String.valueOf(userId));
        headers.set("X-Internal-Secret", internalSecret);

        HttpEntity<CreateCollectionDTO> request = new HttpEntity<>(collectionDTO, headers);

        ResponseEntity<CollectionDTO> response = restTemplate.exchange(url, HttpMethod.POST, request, CollectionDTO.class);

        return response.getBody();
    }
}
