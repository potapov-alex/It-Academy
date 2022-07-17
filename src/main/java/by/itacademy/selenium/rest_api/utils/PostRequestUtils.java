package by.itacademy.selenium.rest_api.utils;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class PostRequestUtils {
    private static final Logger LOG = LoggerFactory.getLogger(PostRequestUtils.class);

    private PostRequestUtils() {
    }

    public static ResponseBody makeRequestAndGetResponseBodyJson(String endpoint, Map<String, Object> headers,
                                                   Map<String, Object> params) {
        return given()
                .contentType(ContentType.JSON)
                .headers(MapUtils.emptyIfNull(headers))
                .queryParams(MapUtils.emptyIfNull(params))
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .getBody();
    }

    public static ResponseBody makeRequestWithBodyAndGetResponseBodyJson(String request, String endpoint, Map<String, Object> headers,
                                                   Map<String, Object> params) {
        return given()
                .contentType(ContentType.JSON)
                .headers(MapUtils.emptyIfNull(headers))
                .queryParams(MapUtils.emptyIfNull(params))
                .body(request)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }
}
