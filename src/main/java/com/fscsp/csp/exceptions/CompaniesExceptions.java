package com.fscsp.csp.exceptions;

public class CompaniesExceptions extends Exception{

    public CompaniesExceptions (ErrMsg errMsg){
        super(errMsg.getDesc());
    }
}
