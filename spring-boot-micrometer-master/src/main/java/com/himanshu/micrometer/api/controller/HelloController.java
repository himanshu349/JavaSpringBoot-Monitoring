package com.himanshu.micrometer.api.controller;


import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {

    @Timed(
            value = "himanshu.micrometer.request",
            histogram = true,
            percentiles = {0.95,0.99},
            extraTags = {"version","1.0"}
    )
    @GetMapping("/test1")
    public String callingTest1Endpoint()
    {

            return "Rest endpoint called by Test 1";

    }
    @Timed(
            value = "himanshu.micrometer.request2",
            histogram = true,
            percentiles = {0.95,0.99},
            extraTags = {"version","1.0"}
    )
    @GetMapping("/test2")
    public String callingTest2Endpoint()
    {
        return "est endpoint called by Test 2";
    }
}
