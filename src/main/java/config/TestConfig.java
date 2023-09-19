package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVeriable.path;
import static constants.Constants.RunVeriable.server;
import static constants.Constants.Servers.SWAPI_URL;

public class TestConfig {

    protected RequestSpecification requestSpecSwapi = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI=server;
        RestAssured.basePath=path;

        RequestSpecification requestSpecificationTest = new RequestSpecBuilder()
        .addHeader("Content-Type", "application/json")
        .addCookie("testCookie")
        .build();

        RestAssured.requestSpecification = requestSpecificationTest;
    }
}
