package com.fscsp.csp.exceptions;

public class CustomersExceptions extends Exception{

    public CustomersExceptions(ErrMsg errMsg){
        super(errMsg.getDesc());
    }
}
