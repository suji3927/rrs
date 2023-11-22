package com.hehe.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    @GetMapping("/test/param")
    public String requestParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return String.format("Hello, Request Param, I am %s, %d", name, age);
    }

    @GetMapping("/test/path/{name}/{age}")
    public String pathVariable(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return String.format("Hello, Path Variable, I am %s, %d", name, age);
    }

    @PostMapping("/test/body")
    public String requestBody(@RequestBody TestRequestBody testRequestBody) {
        return String.format("Hello, Path Variable, I am %s, %d", testRequestBody.name, testRequestBody.age);
    }

    public static class TestRequestBody {
        String name;
        Integer age;
        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
