package com.fscsp.csp.test;

import com.fscsp.csp.beans.*;
import com.fscsp.csp.utils.Art;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Component
//@Order(5)
//@RequiredArgsConstructor
//public class CompanyTestController implements CommandLineRunner {
//    private static final String URL="http://localhost:8079/companies";
//    private static final String AURL="http://localhost:8079/admins";
//    private final RestTemplate restTemplate;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(Art.CONTROLLER);
//        System.out.println("adding some  coupons to see if the CRUD for coupons works");
//        Date utilDate = new Date();
//        java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
//        java.sql.Date sqlDate1Plus = new java.sql.Date(utilDate.getTime() + 500000);
//        Company Heineken2 = new Company("Heineken2","Heineken2@gmail.com","Heineken21234");
//        Coupon coupon9 = new Coupon(Heineken2,"30% OFF","30% off every item in our online store",Category.SHOPPING,sqlDate1,sqlDate1Plus,100,5,"8.jpg");
//        Coupon coupon10 = new Coupon(Heineken2,"35% OFF","35% off every item in our online store",Category.SHOPPING,sqlDate1,sqlDate1Plus,101,6,"8.jpg");
//        List<Coupon>couponList=new ArrayList<>();
//        couponList.add(coupon9);
//        couponList.add(coupon10);
//
//        System.out.println("Create:company Heineken2 (postForEntity)");
//        ResponseEntity<String> res1= restTemplate.postForEntity(AURL+"/addCompany",Heineken2,String.class);
//        if(res1.getStatusCodeValue()==201) {
//            System.out.println("It Works!");
//        }
//
//        System.out.println("Create:buyMe coupon (postForEntity)");
//        System.out.println(" NOT WORKING *TODO*");
////        ResponseEntity<String> res11= restTemplate.postForEntity(URL+"/addCoupon",coupon9,String.class);
////        if(res11.getStatusCodeValue()==201) {
////            System.out.println("It Works!");
////        }
//        System.out.println("Retrieve:gets all coupons with the wanted category(SHOPPING) (getForObject)");
//       restTemplate.getForObject(URL + "/getCompanyCouponsByCategory/" + Category.SHOPPING, ListOfCoupons.class).getCoupons().forEach(System.out::println);
//        System.out.println("It Works!");
//
//        ResponseEntity<String> res3=restTemplate.getForEntity(URL+"/getCompanyCouponsByCategory/"+Category.SHOPPING,String.class);
//        if(res3.getStatusCodeValue()==200) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Retrieve:get the buyMe coupon  (getForEntity)");
//        ResponseEntity<String> res2=restTemplate.getForEntity(URL+"/getCompanyCouponsByCompanyId/"+8,String.class);
//        if(res2.getStatusCodeValue()==200) {
//            System.out.println("It Works!");
//        }
//   }
//}
