package com.fscsp.csp.controllers;

import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.beans.ListOfCompanies;
import com.fscsp.csp.beans.ListOfCustomers;
import com.fscsp.csp.exceptions.CompaniesExceptions;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.exceptions.CustomersExceptions;
import com.fscsp.csp.services.AdminsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RequestMapping("admins")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminsService adminsService;

    @PostMapping("/addCustomer")
    @PreAuthorize("hasAuthority('customer:write')")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer (@RequestBody Customer customer) throws CustomersExceptions, CustomException {
        adminsService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    @PreAuthorize("hasAuthority('customer:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer (@PathVariable int id,@RequestBody Customer customer) throws CustomersExceptions, CustomException {
        adminsService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @PreAuthorize("hasAuthority('customer:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CustomersExceptions, CustomException {
        adminsService.deleteCustomer(id);
    }

    @GetMapping("/getAllCustomers")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ListOfCustomers getAllCustomers() throws CustomException {
        return new ListOfCustomers(adminsService.getAllCustomers());
    }

    @GetMapping("/getOneCustomer/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Customer getOneCustomer(@PathVariable int id) throws CustomersExceptions, CustomException {
        return adminsService.getSingleCustomer(id);
    }

    @PostMapping("/addCompany")
    @PreAuthorize("hasAuthority('company:write')")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany (@RequestBody Company company) throws CompaniesExceptions, CustomException {
        adminsService.addCompany(company);
    }

    @PutMapping("/updateCompany/{id}")
    @PreAuthorize("hasAuthority('company:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany (@PathVariable int id,@RequestBody Company company) throws CompaniesExceptions, CustomException {
        adminsService.updateCompany(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    @PreAuthorize("hasAuthority('company:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CompaniesExceptions, CustomException {
        adminsService.deleteCompany(id);
    }

    @GetMapping("/getAllCompanies")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ListOfCompanies getAllCompanies() throws CustomException {
        return new ListOfCompanies(adminsService.getAllCompanies()) ;
    }

    @GetMapping("/getOneCompany/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Company getOneCompany(@PathVariable int id) throws CompaniesExceptions, CustomException {
        return adminsService.getSingleCompany(id);
    }
}

