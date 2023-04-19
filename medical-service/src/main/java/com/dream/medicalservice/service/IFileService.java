package com.dream.medicalservice.service;

import com.dream.medicalservice.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-10
 */
public interface IFileService extends IService<File> {

    File getFileByFileLink(String file_link);

    List<File> getFileRecord(Integer user_id);

}
