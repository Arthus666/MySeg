package com.dream.segservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dream.segservice.entity.File;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-30
 */
public interface IFileService extends IService<File> {

    File getFileByFileLink(String file_link);

}
