package com.fscsp.csp.clr;


import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.repos.CompaniesRepository;
import com.fscsp.csp.repos.CouponsRepository;
import com.fscsp.csp.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
//@Order(2)
//@RequiredArgsConstructor
//public class Init implements CommandLineRunner {
//
//    private final CompaniesRepository companiesRepository;
//
//    private final CouponsRepository couponsRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
////        System.out.println(Art.INIT);
////        Coupon coupon1 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("10% OFF")
////                .description("10% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(1)
////                .image("8.jpg")
////                .build();
////
////        Coupon coupon2 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("20% OFF")
////                .description("20% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(3)
////                .image("8.jpg")
////                .build();
////
////        Company company1 = Company.builder()
////                .name("Coca-Cola")
////                .email("Coca-Cola@gmail.com")
////                .password("Coca-Cola1234")
////                .coupon(coupon1)
////                .coupon(coupon2)
////                .build();
////
////        companiesRepository.save(company1);
////        companiesRepository.findAll().forEach(System.out::println);
//    }
//}
