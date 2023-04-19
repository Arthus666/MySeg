package com.dream.medicalservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.medicalservice.entity.Introduction;
import com.dream.medicalservice.entity.Result;
import com.dream.medicalservice.enumeration.ResultCode;
import com.dream.medicalservice.service.impl.IntroductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Arthus
 * @since 2023-04-02
 */
@RestController
public class IntroductionController {

    @Autowired
    private IntroductionServiceImpl introductionService;

    @GetMapping("/getIntroductions")
    public Result getIntroductions() {
        QueryWrapper<Introduction> queryWrapper = new QueryWrapper();
        queryWrapper.select("intro_id", "intro_title", "intro_time");
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, introductionService.list(queryWrapper));
    }

    @GetMapping("/getIntroductionById/{intro_id}")
    public Result getIntroductionById(@PathVariable String intro_id) {
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, introductionService.getById(intro_id));
    }

    @GetMapping("/getIntroductionByTitle/{intro_title}")
    public Result getIntroductionByTitle(@PathVariable("intro_title") String intro_title) {
        QueryWrapper<Introduction> queryWrapper = new QueryWrapper();
        queryWrapper.select("intro_id", "intro_title", "intro_time");
        queryWrapper.like("intro_title", intro_title);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, introductionService.list(queryWrapper));

    }

}
