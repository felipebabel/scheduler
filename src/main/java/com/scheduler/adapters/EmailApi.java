package com.scheduler.adapters;

import com.scheduler.util.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sendEmail", url = "http://localhost:8080")
public interface EmailApi {

    @PostMapping("/api/v1/email")
    void sendEmail(@RequestBody EmailDto emailDto);
}
