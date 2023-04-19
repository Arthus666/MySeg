package com.dream.segservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.UUID;

public class Extract {

    private static final Logger logger = LoggerFactory.getLogger(Extract.class);

    private static Process proc = null;

    public static String extract(String segmented_path) {

        logger.info("分割文件路径：{}", segmented_path);

        String extract_path = null;

        try {

            String segmented_dir = segmented_path.substring(0, segmented_path.lastIndexOf('\\') + 1);

            String segmented_name = segmented_path.substring(segmented_path.lastIndexOf('\\') + 1);

            String suffix = segmented_path.substring(segmented_path.indexOf('.'));

            String new_extracted_name = UUID.randomUUID() + suffix;

            String temp = segmented_path.replace("segmented", "extracted");

            //提取文件保存路径
            String extract_dir = temp.substring(0, temp.lastIndexOf('\\') + 1);

            logger.info("文件保存目录：{}", extract_dir);

            extract_path = extract_dir + new_extracted_name;

            //若提取路径不存在则创建文件夹
            File file = new File(extract_dir);
            if (!file.exists()) {
                file.mkdirs();
            }

            //字符串数组设置python环境路径，python文件路径，待分割文件路径（以参数形式传递）
            String[] theArgs = new String[]{"E:\\Anaconda\\python.exe", "E:\\VnetSeg\\PaddleSeg\\extract.py", segmented_dir, extract_dir, segmented_name};
//            String[] theArgs = new String[]{"D:\\Anaconda\\python.exe", "D:\\Java\\MySeg\\seg-service\\PaddleSeg\\extract.py", segmented_dir, extract_dir, segmented_name};

            //执行Py文件
            proc = Runtime.getRuntime().exec(theArgs);

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


            //修改分割的文件名
            File new_extracted = new File(extract_path);

            File extracted = new File(temp);

            extracted.renameTo(new_extracted);

            logger.info("提取文件路径：{}", new_extracted);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            proc.destroy();
            return extract_path;
        }
    }
}
