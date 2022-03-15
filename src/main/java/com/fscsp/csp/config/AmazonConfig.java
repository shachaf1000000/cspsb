//package com.fscsp.csp.config;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AmazonConfig {
//    @Bean
//    public AmazonS3 s3(){
//        AWSCredentials awsCredentials= new BasicAWSCredentials(
//                "AKIAX2A54OFOT2UL5NL3","K4cRM9HgR7Thn1HlJ2RTgWTSTPeAXokzwvUxGTkW");
//        return AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();
//    }
//}
