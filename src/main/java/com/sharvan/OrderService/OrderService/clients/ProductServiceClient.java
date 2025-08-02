package com.sharvan.OrderService.OrderService.clients;

import com.sharvan.OrderService.OrderService.dto.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductByID(Long productId){
        String url = "http://PRODUCTSERVICE/api/products/"+productId;

        ResponseEntity<ProductDTO> entity = restTemplate.getForEntity(url,ProductDTO.class);
        return entity.getBody();
    }
}
