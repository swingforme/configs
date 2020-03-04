package com.example.fortest.onlinereading.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "pay")
public interface PayService {

    @GetMapping(value = "/pay/{fee}")
    public boolean pay(@PathVariable("fee") Double fee);

}
