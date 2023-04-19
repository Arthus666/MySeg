package com.dream.adminservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dream.adminservice.common.Result;
import com.dream.adminservice.common.ResultCode;
import com.dream.adminservice.mapper.HistoryMapper;
import com.dream.adminservice.pojo.History;
import com.dream.adminservice.pojo.User;
import com.dream.adminservice.service.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryMapper historyMapper;
    @GetMapping("getByUserId/{userId}")
    public Result<Map> getByUserId(@PathVariable Long userId,
                                   @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size)
    {
        QueryWrapper<History> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        Page<History> page1 = new Page<>(page, size);
        Page<History> historyPage = historyMapper.selectPage(page1, qw);
        List<History> records = historyPage.getRecords();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",records.size());
        map.put("items",records);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }
}
