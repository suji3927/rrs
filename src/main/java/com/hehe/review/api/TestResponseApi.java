package com.hehe.review.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @PostMapping("/test/response/json")
    public TestResponseBody jsonResponse(@RequestBody TestRequestApi.TestRequestBody testRequestBody) {
        return new TestResponseBody(testRequestBody.name, testRequestBody.age);
    }

    public static class TestResponseBody {
        String name;
        Integer age;
        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
