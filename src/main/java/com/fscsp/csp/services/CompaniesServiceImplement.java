package com.fscsp.csp.services;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.repos.CompaniesRepository;
import com.fscsp.csp.repos.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Scope("prototype")
@Transactional
public class CompaniesServiceImplement extends ClientService implements CompaniesService{
    @Autowired
    CompaniesRepository companiesRepository;
    @Autowired
    CouponsRepository couponsRepository;

    public Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public CompaniesServiceImplement() {
        super();
    }

    public CompaniesServiceImplement(Company company) {
        this.company = company;
    }

    @Override
    public boolean login(String email, String password) {
        if (email != null && password != null) {
            Company id = companiesRepository.findByEmailAndPassword(email, password);
            if ( id != null) {
                System.out.println("Welcome " + id.getName() + "!");
                int companyId = id.getId();
                return true;
            } else {
                System.out.println("incorrect credentials");
            }
        }else {
            System.err.println("EMAIL / PASSWORD ARE NULL, HANDLE THIS IN WEB (put it in required)");
        }
        return false;
    }

    public void addCoupon(Coupon coupon,int companyId) throws CustomException {
        if (coupon.getEndDate() != null && coupon.getStartDate().after(coupon.getEndDate())) {
            throw new CustomException("Cannot add coupon with invalid date range");
        }
        Company company1=companiesRepository.findOneCompanyById(companyId);
       coupon.setCompany(company1);
        couponsRepository.save(coupon);
        System.out.println("the coupon titled " + coupon.getTitle() + " was added successfully!");
    }

    public void updateCoupon(Coupon coupon) throws CustomException {
        if (!(couponsRepository.existsById(coupon.getId()))) {
            throw new CustomException("The coupon doesn't exist, can't update");
        }
        Coupon currCoupon = couponsRepository.findOneCouponById(coupon.getId());

        if (coupon.getStartDate().after(coupon.getEndDate())) {
            throw new CustomException("Cannot update coupon with invalid date range");
        }
        if (coupon.getAmount() < 0) {
            throw new CustomException("Coupon's amount cannot be lower than zero");
        }
        if (coupon.getPrice() <= 0) {
            throw new CustomException("Coupon's Price cannot be lower than zero");
        }
        currCoupon.setCategory(coupon.getCategory());
        currCoupon.setTitle(coupon.getTitle());
        currCoupon.setDescription(coupon.getDescription());
        currCoupon.setStartDate(coupon.getStartDate());
        currCoupon.setStartDate(coupon.getEndDate());
        currCoupon.setAmount(coupon.getAmount());
        currCoupon.setPrice(coupon.getPrice());
        currCoupon.setImage(coupon.getImage());
        couponsRepository.save(currCoupon);
        System.out.println("the coupon " + coupon.getId() + " was updated successfully ");
    }

    public void deleteCoupon(int couponId) throws CustomException {
        if (couponId > 0) {
            List<Coupon> c =  couponsRepository.findById(couponId);
            if (c != null) {
                System.out.println("The coupon with an id of: " + couponId + " has been successfully deleted.");
                couponsRepository.delete(c.get(0));
            } else {
                throw new CustomException("The coupon does not exist in the system");
            }
        } else {
            throw new CustomException("Cannot delete coupon with invalid Id");
        }
    }

    public List<Coupon> getCompanyCouponsByCategory(Category category,Company company) throws CustomException {
        List<Coupon> companyCoupons = couponsRepository.findByCompanyAndCategory(company, category);
        if(companyCoupons.isEmpty()) {
            throw new CustomException("There is no coupons in " + category + " category for this company");
        }
        return companyCoupons;
    }

    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice,Company company) throws CustomException {
        List<Coupon> companyCoupons = couponsRepository.findByCompanyAndPriceLessThan(company, maxPrice);
        if(companyCoupons.isEmpty()) {
            throw new CustomException("There is no coupons cheaper than " + maxPrice + " for this company");
        }
        return companyCoupons;
    }

    @Override
    public List<Coupon> getCompanyCoupons(Company company) throws CustomException {
        List<Coupon> companyCoupons = couponsRepository.findByCompany(company);
        if(companyCoupons.isEmpty()) {
            throw new CustomException("There is no coupons for this company");
        }
        return companyCoupons;
    }

    public Company getCompanyById(int companyId) {

        return companiesRepository.findOneCompanyById(companyId);
    }

//    // Check if the date is after the current date
//    private void checkdate(Date date) throws CustomException {
//        if (date != null) {
//            Date currentDate = Date.valueOf(LocalDate.now());
//
//            if (date.before(currentDate)) {
//                throw new CustomException("The date have to be after the current time");
//            }
//        } else {
//            throw new CustomException("The date have to be valid");
//        }
//    }
}
