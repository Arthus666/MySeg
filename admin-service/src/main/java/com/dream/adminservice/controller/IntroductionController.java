package com.dream.adminservice.controller;


import com.dream.adminservice.common.Result;
import com.dream.adminservice.common.ResultCode;
import com.dream.adminservice.pojo.Introduction;
import com.dream.adminservice.service.IntroductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/introduction")
@Slf4j
public class IntroductionController {

    @Autowired
    private IntroductionService introductionService;


    /**
     * 展示所有信息
     *
     * @return
     */
    @GetMapping("/list")
    public Result<Map> list() {
        List<Introduction> introductions = introductionService.list();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",introductions.size());
        map.put("items",introductions);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }

    /**
     * 新增展示信息
     * @param intro_title
     * @param intro_content
     * @param medical_file
     * @return
     * @throws IOException
     */
    @PostMapping("/add")
    public Result add(@RequestParam("intro_title") String intro_title,
                      @RequestParam("intro_content") String intro_content,
                      @RequestPart("medical_file") MultipartFile medical_file,
                      @RequestPart("whole_file") MultipartFile whole_file) throws IOException {

        //若文件参数为空
        if (medical_file == null) {
            return new Result(ResultCode.FILE_ISNULL.code, ResultCode.FILE_ISNULL.msg);
        }

        System.out.println(medical_file);
        System.out.println(whole_file);


        //获取文件原名
        String file_original_name = medical_file.getOriginalFilename();
        //处理文件重名问题
        String file_suffix = file_original_name.substring(file_original_name.indexOf("."));
        String file_name = UUID.randomUUID() + file_suffix;
        String father_path = "E:\\MedicalService\\IntroductionFiles";
        String whole_path = "E:\\MedicalService\\IntroductionFiles\\Whole";
        File intro_file;
        File a;
        Introduction introduction = new Introduction();
        introduction.setIntroTitle(intro_title);
        introduction.setIntroContent(intro_content);
        introduction.setIntroTime(LocalDateTime.now().toString());

            //获取保存路径
            intro_file = new java.io.File(father_path);

            if (!intro_file.exists()) {
                intro_file.mkdirs();
            }

            a = new java.io.File(whole_path);
            if(!a.exists())
            {
                a.mkdirs();
            }

            String file_path = father_path + java.io.File.separator + file_name;
            String the_whole_path = whole_path + java.io.File.separator + file_name;
            //上传到指定路径
            medical_file.transferTo(new File(file_path));
            whole_file.transferTo(new File(the_whole_path));
            introduction.setIntroOrganPath(file_path);
            introduction.setIntroWholePath(the_whole_path);
        introductionService.save(introduction);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    /**
     * 更新展示文件
     * @param introduction
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Introduction introduction) {
        introduction.setIntroTime(LocalDateTime.now().toString());
        introductionService.updateById(introduction);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    @DeleteMapping("/delete/{introId}")
    public Result delete(@PathVariable Long introId) {
        Introduction introduction = introductionService.getById(introId);
        String introOrganPath = introduction.getIntroOrganPath();
        introductionService.removeById(introId);
        File file1 = new File(introOrganPath);
        if( file1.exists()&& file1.isFile())
            file1.delete();
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }


}
