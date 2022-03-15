package com.fscsp.csp.services;

import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.exceptions.CompaniesExceptions;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.exceptions.CustomersExceptions;

import java.util.List;

public interface AdminsService {
    int addCustomer(Customer customer) throws CustomersExceptions, CustomException;

    void updateCustomer(Customer customer) throws CustomersExceptions, CustomException;

    void deleteCustomer(int id) throws CustomersExceptions, CustomException;

    List<Customer> getAllCustomers() throws CustomException;

    Customer getSingleCustomer(int id) throws CustomersExceptions, CustomException;

    void addCompany(Company company) throws CompaniesExceptions, CustomException;

    void updateCompany(Company company) throws CompaniesExceptions, CustomException;

    void deleteCompany(int id) throws CompaniesExceptions, CustomException;

    List<Company> getAllCompanies() throws CustomException;

    Company getSingleCompany(int id) throws CompaniesExceptions, CustomException;




}
