package com.whfp.framework.core.dao.enums;


public enum Op {
    EQ("=", "等于"),
    NEQ("<>", "不等于"),
    GT(">", "大于"),
    GTE(">=", "大于等于"),
    LT("<", "小于"),
    LTE("<=", "小于等于"),
    LIKE("like", "包含"),
    LIKE_LEFT("like", "左包含"),
    LIKE_RIGHT("like", "右包含"),
    IN("in","包含"),
    NOT_IN("not in","不包含");
    private String msg;
    private String code;

    private Op(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
