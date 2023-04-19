package com.dream.segservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.UUID;

public class VnetSeg {

    private static final Logger logger = LoggerFactory.getLogger(VnetSeg.class);

    private static Process proc = null;

    public static String segment(String unsegmented_path) {

        logger.info("分割前文件路径：{}", unsegmented_path);

        String new_segmented_path = null;

        try {

            String unsegmented_suffix = unsegmented_path.substring(unsegmented_path.indexOf('.'));

            String new_segmented_name = UUID.randomUUID() + unsegmented_suffix;

            String temp = unsegmented_path.replace("unsegmented", "segmented");

            //分割文件保存路径
            String segmented_dir = temp.substring(0, temp.lastIndexOf('\\') + 1);

            logger.info("文件保存目录：{}",segmented_dir);

            new_segmented_path = segmented_dir + new_segmented_name;

            //若分割保存路径不存在则创建文件夹
            File file = new File(segmented_dir);
            if (!file.exists()) {
                file.mkdirs();
            }

            //字符串数组设置python环境路径，python文件路径，待分割文件路径（以参数形式传递）
            String[] theArg = new String[]{"E:\\Anaconda\\python.exe", "E:\\VnetSeg\\PaddleSeg\\vnet_seg.py", unsegmented_path, segmented_dir};

            //执行Py文件
            proc = Runtime.getRuntime().exec(theArg);

            // 读取信息，防止缓冲区满, 导致卡住
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stderr = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "GBK"));
                        while ((line = stderr.readLine()) != null) {
                            logger.warn("stderr:{}", line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
                        while ((line = stdout.readLine()) != null) {
                            logger.warn("stdout:{}", line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            proc.waitFor();

            logger.info("分割后文件路径：{}",new_segmented_path);

            //修改分割的文件名
            File new_segmented = new File(new_segmented_path);

            String file_old_name = unsegmented_path.substring(unsegmented_path.lastIndexOf('\\') + 1);

            File segmented = new File(segmented_dir + file_old_name);

            segmented.renameTo(new_segmented);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            proc.destroy();
            return new_segmented_path;
        }
    }
}
