//package com.fscsp.csp.test;
//
//import com.fscsp.csp.beans.*;
//import com.fscsp.csp.utils.Art;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@Component
//@Order(4)
//@RequiredArgsConstructor
//
//public class AdminTestController implements CommandLineRunner {
//
//    private static final String URL="http://localhost:8079/admins";
//    private final RestTemplate restTemplate;
//    List<Coupon> testing=new ArrayList<Coupon>();
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(Art.CONTROLLER);
//        System.out.println("adding some companies and coupons to see if the CRUD for companies works");
//        Date utilDate = new Date();
//        java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
//        java.sql.Date sqlDate1Plus = new java.sql.Date(utilDate.getTime() + 500000);
////        String plainCreds = "username:password";
////        byte[] plainCredsBytes = plainCreds.getBytes();
////        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
////        String base64Creds = new String(base64CredsBytes);
////        HttpHeaders headers = new HttpHeaders();
////        headers.add("Authorization", "Basic " + base64Creds);
////        HttpEntity<String> request = new HttpEntity<String>(headers);
//        Company Heineken = new Company("Heineken","Heineken@gmail.com","Heineken1234");
//        Coupon coupon7 = new Coupon(Heineken,"15% OFF","15% off every item in our online store", Category.SHOPPING,sqlDate1,sqlDate1Plus,101,2,"8.jpg");
//        Coupon coupon8 = new Coupon(Heineken,"15% OFF","15% off every item in our online store",Category.SHOPPING,sqlDate1,sqlDate1Plus,101,2,"8.jpg");
//
//        System.out.println("Create:company Heineken (postForEntity)");
//           ResponseEntity<String> res1= restTemplate.postForEntity(URL+"/addCompany",Heineken,String.class);
//              if(res1.getStatusCodeValue()==201) {
//                  System.out.println("It Works!");
//              }
//        System.out.println("Retrieve:gets all companies (getForObject)");
//        restTemplate.getForObject(URL + "/getAllCompanies", ListOfCompanies.class).getCompanies().forEach(System.out::println);
//        System.out.println("It Works!");
//        System.out.println("Retrieve:get the Heineken company (getForEntity)");
//        ResponseEntity<String> res2=restTemplate.getForEntity(URL+"/getOneCompany/"+7,String.class);
//        if(res2.getStatusCodeValue()==200) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Update:company Heineken (exchange)");
//        ResponseEntity<String> res3= restTemplate.exchange(URL+"/updateCompany/"+7, HttpMethod.PUT,res2,String.class);
//        if(res3.getStatusCodeValue()==204) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Delete:company Heineken (exchange)");
//        Map< String, Integer > params1 = new HashMap< >();
//        params1.put("id", 7);
//
//        ResponseEntity<String> res4= restTemplate.exchange(URL+"/deleteCompany/"+7,HttpMethod.DELETE,res2,String.class);
//        if(res4.getStatusCodeValue()==204) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Retrieve:gets all companies (getForObject)(expecting without Heineken)");
//        restTemplate.getForObject(URL+"/getAllCompanies", ListOfCompanies.class).getCompanies().forEach(System.out::println);
//        System.out.println("It Works!");
//
//        System.out.println("adding some customers to see if the CRUD for customers works");
//        testing.add(coupon7);
//        testing.add(coupon8);
//        Customer drinkBeer= new Customer("drink","Beer","drinkBeer@gmail.com","drinkBeer1234", (ArrayList<Coupon>) testing);
//
//
//        System.out.println("Create:Customer drink Beer (postForEntity)");
//        ResponseEntity<String> res5= restTemplate.postForEntity(URL+"/addCustomer",drinkBeer,String.class);
//        if(res5.getStatusCodeValue()==201) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Retrieve:gets all Customers (getForObject)");
//        restTemplate.getForObject(URL+"/getAllCustomers", ListOfCustomers.class).getCustomers().forEach(System.out::println);
//        System.out.println("It Works!");
//        System.out.println("Retrieve:get the drinkBeer Customers (getForEntity)");
//        ResponseEntity<String> res6=restTemplate.getForEntity(URL+"/getOneCustomer/"+7,String.class);
//        if(res6.getStatusCodeValue()==200) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Update:Customer drinkBeer (exchange)");
//        ResponseEntity<String> res7= restTemplate.exchange(URL+"/updateCustomer/"+7, HttpMethod.PUT,res6,String.class);
//        if(res7.getStatusCodeValue()==204) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Delete:Customer drinkBeer (exchange)");
//        Map< String, Integer > params2 = new HashMap< >();
//        params2.put("id", 7);
//
//        ResponseEntity<String> res8= restTemplate.exchange(URL+"/deleteCustomer/"+7,HttpMethod.DELETE,res6,String.class);
//        if(res8.getStatusCodeValue()==204) {
//            System.out.println("It Works!");
//        }
//        System.out.println("Retrieve:gets all Customers (getForObject)(expecting without drinkBeer)");
//        restTemplate.getForObject(URL+"/getAllCustomers", ListOfCustomers.class).getCustomers().forEach(System.out::println);
//        System.out.println("It Works!");
//    }
//}
