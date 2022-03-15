package com.fscsp.csp.clr;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.services.AdminsService;
import com.fscsp.csp.services.CompaniesService;
import com.fscsp.csp.utils.Art;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

//@Component
//@Order(3)
//@RequiredArgsConstructor
//public class UseCaseCompaniesService implements CommandLineRunner {
//
//    public final AdminsService companiesService;
//    @Override
//    public void run(String... args) throws Exception {
////        System.out.println(Art.SERVICE);
////        System.out.println("adding some companies");
////        Coupon coupon3 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("15% OFF")
////                .description("15% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(2)
////                .image("8.jpg")
////                .build();
////
////        Coupon coupon4 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("25% OFF")
////                .description("25% off every item in our online store")
////                .startDate(Date.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(4)
////                .image("8.jpg")
////                .build();
////
////        Company company2 = Company.builder()
////                .name("Pepsi")
////                .email("Pepsi@gmail.com")
////                .password("Pepsi1234")
////                .coupon(coupon3)
////                .coupon(coupon4)
////                .build();
////
////        Coupon coupon5 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("30% OFF")
////                .description("30% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(5)
////                .image("8.jpg")
////                .build();
////
////        Coupon coupon6 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("35% OFF")
////                .description("35% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(6)
////                .image("8.jpg")
////                .build();
////
////        Company company3 = Company.builder()
////                .name("XL")
////                .email("XL@gmail.com")
////                .password("XL1234")
////                .coupon(coupon5)
////                .coupon(coupon6)
////                .build();
////        companiesService.addCompany(company2);
////        companiesService.addCompany(company3);
////        System.out.println("getting single company #2");
////        System.out.println(companiesService.getSingleCompany(2));
////        System.out.println("deleting company #2");
////        companiesService.deleteCompany(2);
////        System.out.println("get all companies");
////        companiesService.getAllCompanies().forEach(System.out::println);
//   }
//}
