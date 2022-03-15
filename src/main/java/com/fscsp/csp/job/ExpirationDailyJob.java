package com.fscsp.csp.job;

import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.repos.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Component

public class ExpirationDailyJob {
    @Autowired
    private CouponsRepository couponsRepository;

    public ExpirationDailyJob() {
        super();
    }
    @Scheduled(fixedRate = 86_400_000, initialDelay = 15_000)
    public void removeExpierdCoupon() {
        List<Coupon> couponToDelete = couponsRepository
                .findByEndDateBefore(new Date(Calendar.getInstance().getTime().getTime()));
        try {
            for (Coupon cpn : couponToDelete) {
                couponsRepository.delete(cpn);
                System.out.println(cpn+" deleted successfully");
            }
        } catch (Exception e) {
            System.out.println(("Exception in ExpirationDailyJob - " + e.getMessage()));
        }
    }
}
