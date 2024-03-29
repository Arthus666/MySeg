package com.dream.userservice.enumeration;

public enum ResultCode {

    //状态码
    CONTINUE("100", "继续请求"),
    SUCCESS("200", "请求成功"),
    MULTIPLE_CHOICES("300", "多种选择"),
    BAD_REQUEST("400", "错误请求"),
    INTERNAL_ERROR("500", "内部错误"),

    //自定义
    EMAIL_ISNULL("2001", "邮箱不能为空"),
    USER_TOKEN_ISNULL("2002", "user_token为空"),
    USER_TOKEN_MISMATCH("2003", "user_token验证失败"),
    INPUT_ISNULL("2004", "输入框不能为空"),
    USERNAME_FORMAT_MISMACTH("2005", "用户名格式为英文字母、数字、下划线、长度3~16位"),
    USER_PASSWORD_FORMAT_MISMATCH("2006", "密码格式为英文字母、数字、下划线、长度6~16位"),
    USER_CONFIRM_MISMATCH("2007", "确认密码不一致"),
    EMAIL_FORMAT_MISMATCH("2008", "邮箱格式不正确"),
    VERTIFYCODE_MISMATCH("2009", "验证码错误"),
    USER_NAME_DUPLICATE("20010", "用户名已存在"),
    USER_EMAIL_DUPLICATE("20011", "该邮箱已注册"),
    USER_EMAIL_OR_PASSWORD_MISMATCH("20013", "邮箱或密码错误"),
    USER_NAME_OR_PASSWORD_MISMATCH("20014", "用户名或密码错误"),
    FUNCTION_NOT_EXIST("20015", "功能不存在");

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
