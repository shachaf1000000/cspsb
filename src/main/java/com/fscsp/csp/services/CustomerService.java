package com.fscsp.csp.services;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.exceptions.CustomException;
import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponId) throws CustomException;

    List<Coupon> getCustomerCoupons() throws CustomException;

    List<Coupon> getCustomerCouponsByCategory(Category category) throws CustomException;

    List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) throws CustomException;

    Customer getCustomerDetails() throws CustomException;

    Customer getCustomerById(int id)throws CustomException;
}
