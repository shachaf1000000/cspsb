package com.fscsp.csp.services;

import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.repos.CompaniesRepository;
import com.fscsp.csp.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@EnableWebMvc
public class AdminsServiceImplement extends ClientService implements AdminsService {
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    CompaniesRepository companiesRepository;

    private final String EMAIL = "Admin@gmail.com";
    private final String PASSWORD = "Admin1234";

    public AdminsServiceImplement() {
    }

    @Override
    public boolean login(String email, String password){
        if (email != null && password != null) {
            if (email.equalsIgnoreCase(EMAIL) && password.equals(PASSWORD)) {
                System.out.println("Welcome Admin!");
                return true;
            }else {
                System.out.println("incorrect credentials");
            }
        }else {
            System.err.println("EMAIL / PASSWORD ARE NULL, HANDLE THIS IN WEB (put it in required)");
        }
        return false;
    }
    public void addCompany(Company company) throws CustomException {
        if (company != null) {
            if (!companiesRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
                companiesRepository.save(company);
                System.out.println("The"+ company.getName()+" company was added successfully");

            } else {
                throw new CustomException("Company already exists");
            }
        } else {
            throw new CustomException("Cannot add empty company");
        }
    }
    public void updateCompany(Company company) throws CustomException {
        List<Company> check = companiesRepository.findByIdAndName(company.getId(), company.getName());
        if (check.isEmpty()) {
            throw new CustomException("The " + company.getName() + " doesn't exist in the system " + "And The "
                    + company.getId() + " doesn't exist in the system "+"Please note that you can not update the company name!");
        }
        Company company1=check.get(0);
        company1.setName(company.getName());
        company1.setEmail(company.getEmail());
        company1.setPassword(company.getPassword());
        companiesRepository.saveAndFlush(company1);
        System.out.println("Company " + company.getName() + " has been updated sucessfully");
    }
    public void deleteCompany(int companyId) throws CustomException {
        if (!(companiesRepository.existsById(companyId))) {
            throw new CustomException("The company does not exist in the system");
        }

        companiesRepository.deleteById(companyId);
        System.out.println("the Company with the id " +companyId + " was sucessfully deleted.");
    }
    public ArrayList<Company> getAllCompanies() throws CustomException {
        if (companiesRepository.findAll().isEmpty()) {
            throw new CustomException("There are no companies in the system ");
        }
        System.out.println("Here are all the companies: " + companiesRepository.findAll());
        return (ArrayList<Company>) companiesRepository.findAll();
    }
    public Company getSingleCompany(int companyId) throws CustomException {
        if (!companiesRepository.existsById(companyId)) {
            throw new CustomException("No company found with this specific Id");
        }
        Company currCompany=companiesRepository.findOneCompanyById(companyId);
        List<Coupon> couponsCompany = couponsRepository.findByCompany(currCompany);
        currCompany.setCoupons(couponsCompany);
        System.out.println("The company you've requested is: " + currCompany);
        return currCompany;
    }
    public int addCustomer(Customer customer) throws CustomException {
        if (customer != null) {
            if (!customersRepository.existsByEmail(customer.getEmail())) {
                int id = customersRepository.save(customer).getId();
                System.out.println("Customer " + customer.getFirstName() + " has been added successfully!");
                return id;
            } else {
                throw new CustomException("Cannot add this specific email - This email already exists in the system");
            }
        } else {
            throw new CustomException("Cannot add empty customer");
        }
    }
    public void updateCustomer(Customer customer) throws CustomException {
        if (!customersRepository.existsById(customer.getId())) {
            throw new CustomException(customer.getFirstName() + " " + customer.getLastName() + " doesn't exist in the system");
        }
        Customer currCustomer = customersRepository.findOneCustomerById(customer.getId());
        currCustomer.setFirstName(customer.getFirstName());
        currCustomer.setLastName(customer.getLastName());
        currCustomer.setEmail(customer.getEmail());
        currCustomer.setPassword(customer.getPassword());
        customersRepository.saveAndFlush(currCustomer);
        System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName() + " has been updated sucessfully");
    }
    public void deleteCustomer(int customerId) throws CustomException {
        if (!customersRepository.existsById(customerId)) {
            throw new CustomException("No customer found with this specific Id");
        }
        Customer customer=customersRepository.findOneCustomerById(customerId);
        customersRepository.deleteById(customerId);
        couponsRepository.deleteByCustomers(customer);
        System.out.println("Customer " + customer.getFirstName() + " was sucessfully deleted.");
    }
    public ArrayList<Customer> getAllCustomers() throws CustomException {
        if ((customersRepository.findAll().isEmpty())) {
            throw new CustomException("There are no customers in the system");
        }
        System.out.println("Here are all the customers: " + customersRepository.findAll());
        return (ArrayList<Customer>) customersRepository.findAll();
    }
    public Customer getSingleCustomer(int customerId) throws CustomException {
        if (!customersRepository.existsById(customerId)) {
            throw new CustomException("No customer found with this specific Id");
        }
        Customer customer=customersRepository.findOneCustomerById(customerId);
        customer.setCoupons((ArrayList<Coupon>) couponsRepository.findByCustomers(customer));
        System.out.println("The customer you requested is: " + customer);
        return customer;
    }
}
