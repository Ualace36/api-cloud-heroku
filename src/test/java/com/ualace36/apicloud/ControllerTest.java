package com.ualace36.apicloud;

import com.ualace36.apicloud.model.Parking;
import com.ualace36.apicloud.model.dto.ParkingCreateDTO;
import com.ualace36.apicloud.model.dto.ParkingDTO;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsRestAssuredConfigurationCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

  @LocalServerPort
  private int randomPort;

  @BeforeEach
  public void setUpTest(){
    System.out.println(randomPort);
    RestAssured.port = randomPort;
  }

  @Test
    void whenfindAllThenCheckResult(){
    RestAssured.given()
            .when()
            .get("/parking")
            .then()
            .statusCode(201)
            .body("license[0]", Matchers.equalTo("cxzc"));
//            .extract().response()
//            .body().prettyPrint();
  }

  @Test
  void whencreateThenCheckIsCreTed(){
    var createDTO = new ParkingCreateDTO();
    createDTO.setLicense("naz 4512");
    createDTO.setModel("Palio");
    createDTO.setState("Ba");
    createDTO.setColor("Azul");
    RestAssured.given()
    .when()
            .body(createDTO)
            .post("/parking")
            .then()
            .statusCode(201)
            .body("license", Matchers.equalTo("naz 4512"));

  }
}
