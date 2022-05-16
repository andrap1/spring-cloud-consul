package com.example.shopservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopDelegateService {

    @Autowired
    RestTemplate restTemplate;


    public String getDataFromProductService(String shopName){
        try {
            String response= restTemplate.exchange("http://product-service/products/{shopName}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            }, shopName).getBody();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }
}
