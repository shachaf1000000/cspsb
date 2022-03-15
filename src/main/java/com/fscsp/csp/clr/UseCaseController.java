package com.fscsp.csp.clr;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.ListOfCompanies;
import com.fscsp.csp.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

//@Component
//@Order(4)
//@RequiredArgsConstructor
//public class UseCaseController implements CommandLineRunner {
//    private static final String URL="http://localhost:8080/companies";
//    private static final String URLPLUSID="http://localhost:8080/companies/{id}";
//
//    private final RestTemplate restTemplate;
//    @Override
//    public void run(String... args) throws Exception {
////        System.out.println(Art.CONTROLLER);
////        System.out.println("adding some companies");
////
////        Coupon coupon7 = Coupon.builder()
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
////        Coupon coupon8 = Coupon.builder()
////                .category(Category.SHOPPING)
////                .title("25% OFF")
////                .description("25% off every item in our online store")
////                .startDate(LocalDate.now())
////                .endDate(LocalDate.now().plusMonths(1))
////                .amount(100)
////                .price(4)
////                .image("8.jpg")
////                .build();
////
////        Company company4 = Company.builder()
////                .name("Heineken")
////                .email("Heineken@gmail.com")
////                .password("Heineken1234")
////                .coupon(coupon7)
////                .coupon(coupon8)
////                .build();
////
////        Coupon coupon9 = Coupon.builder()
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
////        Coupon coupon10 = Coupon.builder()
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
////        Company company5 = Company.builder()
////                .name("Nestlé")
////                .email("Nestlé@gmail.com")
////                .password("Nestlé1234")
////                .coupon(coupon9)
////                .coupon(coupon10)
////                .build();
//////        Company company6 = Company.builder()
//////                .name("Nestlé-Premium")
//////                .email("Nestlé-Premium@gmail.com")
//////                .password("Nestlé-Premium1234")
//////                .coupon(coupon9)
//////                .coupon(coupon10)
//////                .build();
////
////         ResponseEntity<String> res1= restTemplate.postForEntity(URL,company4,String.class);
////             System.out.println(res1.getStatusCodeValue()==201);
////         ResponseEntity<String> res2= restTemplate.postForEntity(URL,company5,String.class);
////             System.out.println(res2.getStatusCodeValue()==201);
////        System.out.println("gets all companies");
////            restTemplate.getForObject(URL, ListOfCompanies.class).getCompanies().forEach(System.out::println);
////        System.out.println("get company #4");
////        ResponseEntity<String> res3=restTemplate.getForEntity(URL+"/4",String.class);
////        System.out.println(res3.getStatusCodeValue()==200);
////        System.out.println("update company #5");
////
////        ResponseEntity<String> res4= restTemplate.exchange(URL+"/5",HttpMethod.PUT,res3,String.class);
////        System.out.println(res4.getStatusCodeValue()==204);
////        System.out.println("delete company #5");
//////        Map < String, Integer > params = new HashMap < > ();
//////        params.put("id", 3);
//////        restTemplate.delete(URL+"/3",params);
////        ResponseEntity<String> res5= restTemplate.exchange(URL+"/5",HttpMethod.DELETE,res3,String.class);
////        System.out.println(res4.getStatusCodeValue()==204);
//    }
//}
