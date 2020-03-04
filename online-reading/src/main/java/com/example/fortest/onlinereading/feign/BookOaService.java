package com.example.fortest.onlinereading.feign;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Component
@FeignClient(value = "bookoa")
public interface BookOaService {

    @GetMapping(value = "/addBook/{id}/{name}")
    Boolean addBook(@PathVariable("id") Integer id, @PathVariable("name") String name);

    @GetMapping(value = "/addBook/{name}")
    Map<Integer,String> getBookLike(@PathVariable("name") String book);
}
