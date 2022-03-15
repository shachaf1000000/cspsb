package com.fscsp.csp.exceptions;

public enum ErrMsg {
    ID_ALREADY_EXIST("Id already exist"),
    ID_NOT_FOUND("Id not Found");

    private String desc;

    ErrMsg(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
