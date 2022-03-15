package com.fscsp.csp.repos;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface CouponsRepository extends JpaRepository<Coupon,Integer> {
    default Coupon findOneCouponById(int couponId) {
        return findById(couponId).iterator().next();
    }

    void deleteByCustomers(Customer customer);

    boolean existsByTitle(String title);

    List <Coupon> findById(int couponId) ;

    List <Coupon> findByCompany(Company company);

    List <Coupon> findByCustomers(Customer customer) ;

    List<Coupon> findByCompanyAndCategory(Company company, Category category);

    List<Coupon> findByCompanyAndPriceLessThan(Company company, double maxPrice);

    List<Coupon> findByCustomersAndCategory(Customer customer, Category category);

    List<Coupon> findByCustomersAndPriceLessThan(Customer customer, double maxPrice);

    List<Coupon> findByEndDateBefore(Date date);
}
