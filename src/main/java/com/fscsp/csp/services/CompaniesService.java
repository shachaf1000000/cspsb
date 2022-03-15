package com.fscsp.csp.services;
import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.exceptions.CompaniesExceptions;
import com.fscsp.csp.exceptions.CustomException;
import java.util.List;

public interface CompaniesService {

    void addCoupon(Coupon coupon,int companyId) throws CustomException, CompaniesExceptions;

    void updateCoupon(Coupon coupon) throws CustomException, CompaniesExceptions;

    void deleteCoupon(int id) throws CustomException, CompaniesExceptions;

    Company getCompanyById(int companyId)throws CustomException, CompaniesExceptions;

    List<Coupon> getCompanyCouponsByCategory(Category category,Company company) throws CustomException, CompaniesExceptions;

    List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice,Company company) throws CustomException, CompaniesExceptions;

    List<Coupon> getCompanyCoupons(Company company)throws CustomException ;
}
