package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.IntroductionMapper;
import com.dream.adminservice.pojo.Introduction;
import com.dream.adminservice.service.IntroductionService;
import org.springframework.stereotype.Service;

@Service
public class IntroductionServiceImpl extends ServiceImpl<IntroductionMapper, Introduction> implements IntroductionService {
}
