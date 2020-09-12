package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.CheckClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.response.GeneralResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CheckClientServiceImpl implements CheckClientService {
    private final CheckClientConverter checkClientConverter;
    private final RestTemplate restTemplate;
    @Override
    public void checkClient(CreateClient createClient) {
        CheckClient request = checkClientConverter.convert(createClient);
        GeneralResponse generalResponse = restTemplate.postForObject("check-ult", request, GeneralResponse.class);
        if (generalResponse.isSuccess()) {
            throw new IllegalStateException();
        }
    }
}
