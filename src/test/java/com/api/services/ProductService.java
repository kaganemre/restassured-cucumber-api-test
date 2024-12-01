package com.api.services;

import com.api.utils.Base;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductService extends Base {

    public static void createToken(){

        String body = """
                        {
                          "email": "info@adminuser.com",
                          "password": "Password_536"
                        }
                       """;

        response = given(spec)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/api/users/login");
    }

    public static void validateToken(){

        assertEquals(200, response.statusCode());
        token = response.path("token");

    }

    public static void addProduct(){

        String body = """
                        {
                           "name": "Eddie Van Halen HFT",
                           "price": 7000,
                           "description": "Eddie Van Halen signature series",
                           "image": "7.png",
                           "categoryId": 1
                         }
                      """;

        response = given(spec)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .and()
                    .body(body)
                    .when().log().all()
                    .post("/api/products");

        assertEquals(201, response.statusCode());
        productId = response.path("id");


    }

    public static void validatePostProduct(){
        productValidation("Eddie Van Halen HFT", 7000, "Eddie Van Halen signature series", "7.png", 1);
    }

    public static void updateProduct(){

        String body = """
                        {
                           "id": %d,
                           "name": "EVH HFT",
                           "price": 6000,
                           "description": "EVH signature",
                           "image": "20aflsdl.png",
                           "categoryId": 2
                         }
                      """.formatted(productId);

        response = given(spec)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .and()
                    .body(body)
                    .when().log().all()
                    .put("/api/products");

        assertEquals(200, response.statusCode());

    }

    public static void validatePutProduct(){
        productValidation("EVH HFT", 6000, "EVH signature", "20aflsdl.png", 2);
    }

    public static void deleteProduct(){

        response = given(spec)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .delete("/api/products/" + productId);

        assertEquals(204, response.statusCode());
    }

    public static void productValidation(String name, int price, String description, String image, int categoryId){

            assertAll("product",
                () -> assertEquals(name, response.path("name")),
                () -> assertEquals(price, (int)response.path("price")),
                () -> assertEquals(description, response.path("description")),
                () -> assertEquals(image, response.path("image")),
                () -> assertEquals(categoryId, (int)response.path("categoryId"))
            );
    }

}
