package com.dream.segservice.enumeration;

public enum ResultCode {

    //状态码
    CONTINUE("100", "继续请求"),
    SUCCESS("200", "请求成功"),
    MULTIPLE_CHOICES("300", "多种选择"),
    BAD_REQUEST("400", "错误请求"),
    INTERNAL_ERROR("500", "内部错误"),

    //自定义
    FILE_ISNULL("20015", "文件为空"),
    FILE_DIRECTORY_NOT_EXIST("20016", "父目录不存在"),
    FILE_STATUS_INCORRECT("20017", "文件状态不正确"),
    INPUT_ISNULL("20018", "参数不能为空"),
    USER_ID_MISMATCH("20019", "用户id不匹配或文件不存在"),
    USER_ID_NOT_THE_SAME("20020", "用户id不一致"),
    DIRECTORY_IS_FILE("20021", "目录为文件"),
    FILE_NOT_FOUND("20022", "找不到文件"),
    FILE_OR_DIRECTORY_NOT_FOUND("20023", "找不到文件或目录"),
    USERID_MISMATCH("20024", "用户id不匹配"),
    FILE_SEGMENTED("20025", "文件已分割"),
    FILE_UNSEGMENTED("20025", "文件未分割");

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
