package com.fscsp.csp.exceptions;

public class CouponsExceptions extends Exception{

    public CouponsExceptions(ErrMsg errMsg){
        super(errMsg.getDesc());
    }
}
