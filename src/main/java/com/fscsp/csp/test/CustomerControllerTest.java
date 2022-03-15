package com.fscsp.csp.test;

import com.fscsp.csp.beans.*;
import com.fscsp.csp.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

//@Component
//@Order(6)
//@RequiredArgsConstructor
//public class CustomerControllerTest implements CommandLineRunner {
//    private static final String URL="http://localhost:8079/customers";
//    private final RestTemplate restTemplate;
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(Art.CONTROLLER);
//        System.out.println("adding some  customers to see if the CRUD for customers works");
//        Date utilDate = new Date();
//        java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
//        java.sql.Date sqlDate1Plus = new java.sql.Date(utilDate.getTime() + 500000);
//
//        Company Heineken3 = new Company("Heineken3","Heineken3@gmail.com","Heineken31234");
//        Coupon coupon99 = new Coupon(27,Heineken3,"35% OFF","35% off every item in our online store",Category.SHOPPING,sqlDate1,sqlDate1Plus,101,6,"8.jpg");
//        Coupon coupon100 = new Coupon(Heineken3,"35% OFF","35% off every item in our online store",Category.SHOPPING,sqlDate1,sqlDate1Plus,101,6,"8.jpg");
//
//       System.out.println("Create:purchaseCoupon  (postForEntity)");
//        System.out.println(" NOT WORKING *TODO*");
////        ResponseEntity<String> res1= restTemplate.postForEntity(URL+"/purchaseCoupon",coupon99,String.class);
////        if(res1.getStatusCodeValue()==201) {
////            System.out.println("It Works!");
////        }
//        System.out.println("Retrieve:gets all coupons with the wanted category(SHOPPING) (getForObject)");
//        System.out.println(" NOT WORKING *TODO*");
////        restTemplate.getForObject(URL + "/getCustomerCouponsByCategory/" + Category.SHOPPING, ListOfCustomers.class).getCustomers().forEach(System.out::println);
////        System.out.println("It Works!");
//
////        ResponseEntity<String> res3=restTemplate.getForEntity(URL+"/getCustomerCouponsByCategory/"+Category.SHOPPING,String.class);
////        if(res3.getStatusCodeValue()==200) {
////            System.out.println("It Works!");
////        }
//        System.out.println("Retrieve:get the buyMe coupon  (getForEntity)");
//        System.out.println(" NOT WORKING *TODO*");
////        ResponseEntity<String> res2=restTemplate.getForEntity(URL+"/getCustomerCouponsByMaxPrice/"+8,String.class);
////        if(res2.getStatusCodeValue()==200) {
////            System.out.println("It Works!");
////        }
//
//    }
//}
