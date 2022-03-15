package com.fscsp.csp.repos;

import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepository extends JpaRepository<Customer,Integer> {

    default Customer findOneCustomerById(int customerId) {
        return findById(customerId).iterator().next();
    }

    void deleteById(int customerId);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String Email);

    List <Customer> findById(int customerId) ;

    List <Customer> findByEmail(String customerEmail) ;

    List <Customer> findByCoupons(Coupon coupon);
}
