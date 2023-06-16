package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

class PostmanEchoTest {
    @Test
    void testWithPostmanEcho() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("some data"));
        ;
    }
    @Test
    void testWithPostmanEchoCyrillicScript() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Добро пожаловать")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Добро пожаловать!"));
        ;
    }
}
