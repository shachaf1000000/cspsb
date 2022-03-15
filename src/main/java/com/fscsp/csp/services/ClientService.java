package com.fscsp.csp.services;

import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.repos.CompaniesRepository;
import com.fscsp.csp.repos.CouponsRepository;
import com.fscsp.csp.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {
    @Autowired
    protected CompaniesRepository companiesRepository;
    @Autowired
    protected CustomersRepository customersRepository;
    @Autowired
    protected CouponsRepository couponsRepository;

    public abstract boolean login(String email, String password) throws CustomException;
}
