package com.fscsp.csp.controllers;
import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.exceptions.CustomersExceptions;
import com.fscsp.csp.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/purchaseCoupon/{couponId}")
    @PreAuthorize("hasAuthority('coupon:read')")
    @ResponseStatus(HttpStatus.CREATED)
    public void purchaseCoupon (@PathVariable int couponId) throws CustomException, CustomersExceptions {
        customerService.purchaseCoupon(couponId);
    }

    @GetMapping("/getCustomerCoupons")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCustomerCoupons() throws CustomException, CustomersExceptions {
        return customerService.getCustomerCoupons();
    }

    @GetMapping("/getCustomerCouponsByCategory/{category}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCustomerCouponsByCategory(@PathVariable Category category) throws CustomException, CustomersExceptions {
        return customerService.getCustomerCouponsByCategory(category);
    }

    @GetMapping("/getCustomerCouponsByMaxPrice/{maxPrice}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public List<Coupon> getCustomerCouponsByMaxPrice(@PathVariable int maxPrice) throws CustomException, CustomersExceptions {
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("/getCustomerDetails")
    @PreAuthorize("hasAuthority('coupon:read')")
    public Customer getCustomerDetails() throws CustomException, CustomersExceptions {
        return  customerService.getCustomerDetails();
    }

    @GetMapping("/getCustomerById/{customerId}")
    @PreAuthorize("hasAuthority('coupon:read')")
    public Customer getCustomerById(@PathVariable int customerId) throws CustomException, CustomersExceptions {
        return customerService.getCustomerById(customerId);
    }
}
