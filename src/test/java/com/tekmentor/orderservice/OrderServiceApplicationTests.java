package com.tekmentor.orderservice;

import com.tekmentor.orderservice.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static io.restassured.RestAssured.given;

@SpringBootTest
class OrderServiceApplicationTests {

    @Test
    void fetchAllOrders() {
        given()
                .log().all()
                .when()
                .get("http://localhost:8092/orders")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void addNewOrder(){
        Order order = new Order("", new Date(),"cust-2232",450.0);

        given()
                .log().all()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post("http://localhost:8092/orders")
                .then()
                .statusCode(201);
    }

    @Test
    void fetchSpecificOrderForAGivenCustomer(){
        given()
                .log().all()
                .when()
                .get("http://localhost:8092/orders/customers/{customerId}","cust-2232")
                .then()
                .statusCode(200)
                .log().all();

    }

}
