package com.dream.medicalservice.consumer;

import com.dream.medicalservice.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/getUsageCount/{user_id}")
    Result getUsageCount(@PathVariable("user_id") Integer user_id);

    @GetMapping("/getUserHistory/{user_id}")
    Result getUserHistory(@PathVariable("user_id") Integer user_id);

    @GetMapping("/getTotalCount")
    Result getTotalCount();

    @PutMapping("/usageCount/{user_id}/{latest_function}/{latest_file}")
    Result usageCount(@PathVariable("user_id") Integer user_id, @PathVariable("latest_function") String latest_function, @PathVariable("latest_file") String latest_file);

}
