package com.fscsp.csp.services;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.exceptions.CustomException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class CustomersServiceImplement extends ClientService implements CustomerService{
    private Customer customer;

    public CustomersServiceImplement() {
    }

    @Override
    public boolean login(String email, String password){
        if (customersRepository.existsByEmailAndPassword(email, password)) {
            customer=customersRepository.findByEmail(email).iterator().next();
            System.out.println("Welcome " + customer.getFirstName() + "!");
            return true;
        }
        return false;
    }

    public void purchaseCoupon(int couponId) throws CustomException {
        Coupon coupon;
        coupon = couponsRepository.findOneCouponById(couponId);

        if (coupon.equals(null)) {
            throw new CustomException("Coupon with id: "+couponId+" doesn't exist");
        }

        if (coupon.getPrice()==0) {
            throw new CustomException("Can't purchase, the coupon price is 0.");
        }

        if (coupon.getEndDate().getTime() <= Calendar.getInstance().getTime().getTime()) {
            throw new CustomException("Can't purchase, the coupon is expired");
        }

        if (coupon.getAmount()==0) {
            throw new CustomException("The coupon sold out.....sorry");
        }

        List<Coupon> coupons = new ArrayList<>();
        try {
            coupons = getCustomerCoupons();
            if (coupons.contains(coupon)) {
                throw new CustomException("You have already bought this coupon");
            }
        } catch (CustomException e) {
        }

        List <Customer> customers=customersRepository.findByCoupons(coupon);
        customers.add(customer);
        coupon.setCustomers(customers);
        coupon.setAmount(coupon.getAmount()-1);
        couponsRepository.save(coupon);
    }

    public List<Coupon> getCustomerCoupons() throws CustomException {
        List<Coupon> customerCoupons = couponsRepository.findByCustomers(customer);
        if(customerCoupons.isEmpty()) {
            throw new CustomException("There is no coupons for this customer");
        }
        return couponsRepository.findByCustomers(customer);
    }

    public List<Coupon> getCustomerCouponsByCategory(Category category) throws CustomException {
        List<Coupon> customerCoupons = couponsRepository.findByCustomersAndCategory(customer, category);
        if(customerCoupons.isEmpty()) {
            throw new CustomException("There is no coupons in " + category + " category for this customer");
        }
        return customerCoupons;
    }

    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) throws CustomException {
        List<Coupon> customerCoupons = couponsRepository.findByCustomersAndPriceLessThan(customer, maxPrice);
        if(customerCoupons.isEmpty()) {
            throw new CustomException("There is no coupons cheaper than " + maxPrice + " for this customer");
        }
        return customerCoupons;
    }

    public Customer getCustomerDetails() throws CustomException {
        customer.setCoupons((ArrayList<Coupon>) getCustomerCoupons());
        return customer;
    }

    public Customer getCustomerById(int id) {
        return customersRepository.findOneCustomerById(id);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
