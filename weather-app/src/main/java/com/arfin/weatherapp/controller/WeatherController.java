package com.arfin.weatherapp.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/current/weather")
    @HystrixCommand(fallbackMethod = "getWeatherFallback")
    public String getWeather(){
        return "The weather is" + restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
    }

    public String getWeatherFallback(){
        return "defalult response";
    }
}
