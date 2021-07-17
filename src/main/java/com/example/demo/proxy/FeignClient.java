package com.example.demo.proxy;

import com.example.demo.controller.json.Parent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(url = "localhost:8080", name="users", fallback = FeignClientFallback.class)
public interface FeignClient {

    @PostMapping("/root/root/post")
    Parent fetchParent(@RequestBody Parent parent);

}

@Slf4j
class FeignClientFallback implements FeignClient{

    @Override
    public Parent fetchParent(Parent parent) {
        log.info("Fallback method - called");
        return new Parent();
    }
}
