package com.fscsp.csp.controllers;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.exceptions.CompaniesExceptions;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.services.CompaniesService;
import com.fscsp.csp.services.CompaniesServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("companies")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompaniesService companiesService;
    private final CompaniesServiceImplement companiesServiceImplement;

    @PostMapping("/addCoupon/{companyId}")
    @PreAuthorize("hasAuthority('coupon:write')")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon (@RequestBody Coupon coupon,@PathVariable int companyId) throws CompaniesExceptions, CustomException {
        Coupon currCoupon = coupon;
        currCoupon.setCompany(companiesServiceImplement.getCompanyById(companyId));
        companiesService.addCoupon(currCoupon,companyId);
    }

    @PutMapping("/updateCoupon/{id}")
    @PreAuthorize("hasAuthority('coupon:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id,@RequestBody Coupon coupon) throws CompaniesExceptions, CustomException {
        companiesService.updateCoupon(coupon);
    }

    @DeleteMapping("/deleteCoupon/{id}")
    @PreAuthorize("hasAuthority('coupon:write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int id) throws CompaniesExceptions, CustomException {
        companiesService.deleteCoupon(id);
    }

    @GetMapping("/getCompanyCoupons")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCompanyCoupons(@RequestBody Company company)throws CompaniesExceptions, CustomException{
        return companiesService.getCompanyCoupons(company);
    }

    @GetMapping("/getCompanyCouponsByCategory/{category}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCompanyCouponsByCategory(@PathVariable Category category,@RequestBody Company company) throws CompaniesExceptions, CustomException {
        List<Coupon> coupons =  companiesService.getCompanyCouponsByCategory(category,company);
        return coupons;
    }

    @GetMapping("/getCompanyCouponsByMaxPrice/{maxPrice}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCompanyCouponsByMaxPrice(@PathVariable double maxPrice,@RequestBody Company company) throws CompaniesExceptions, CustomException {
        List<Coupon> coupons =  companiesService.getCompanyCouponsByMaxPrice(maxPrice,company);
        return coupons;
    }

    @GetMapping("/getCompanyById/{id}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public Company getCompanyById(@PathVariable int id) throws CompaniesExceptions, CustomException{
        return companiesService.getCompanyById(id);
    }
}
