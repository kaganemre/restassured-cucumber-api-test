package com.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

public class Base {

    public static Response response;
    public static String token;
    public static int productId;

    public static RequestSpecification spec = new RequestSpecBuilder()
                                                    .setBaseUri("http://localhost:5191")
                                                    .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter()))
                                                    .build();



}
