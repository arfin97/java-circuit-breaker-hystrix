package com.arfin.weatherservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Controller
@RestController
public class WeatherService {


    @RequestMapping("/weather")
    @HystrixCommand(fallbackMethod = "getWeatherFallback")
    public String getWeatherInservice(){
        String[] str = {"sunny", "cloudy", "rainy"};
        var random = new Random().nextInt(str.length);
        return str[random];
    }

    public String getWeatherFallback(){
        return "default response from service";
    }


}
