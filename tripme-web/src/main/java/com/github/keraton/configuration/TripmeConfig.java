package com.github.keraton.configuration;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.github.keraton.model.request.FlightRequest;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import javax.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class TripmeConfig  implements AsyncConfigurer {

    @Bean
    ObjectMapper mapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    RestTemplate restTemplate(ObjectMapper objectMapper) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(aMessageConverter(objectMapper));
        return restTemplate;
    }


    private List<HttpMessageConverter<?>> aMessageConverter(ObjectMapper objectMapper) {
        HttpMessageConverter<?> messageConverter = new MappingJackson2HttpMessageConverter();
        ((MappingJackson2HttpMessageConverter) messageConverter).setObjectMapper(objectMapper);
        return Arrays.asList(messageConverter);
    }

    @Override
    public Executor getAsyncExecutor() {
        return Executors.newFixedThreadPool(2);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
