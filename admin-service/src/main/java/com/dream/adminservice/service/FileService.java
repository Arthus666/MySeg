package com.dream.adminservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dream.adminservice.pojo.File;

public interface FileService extends IService<File> {

    File getFileByFileLink(String fileLink);
}
