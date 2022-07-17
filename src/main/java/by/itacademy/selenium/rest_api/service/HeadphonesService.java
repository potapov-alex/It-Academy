package by.itacademy.selenium.rest_api.service;

import by.itacademy.selenium.rest_api.model.HeadphonesFacet;
import by.itacademy.selenium.rest_api.utils.GetRequestUtils;
import by.itacademy.selenium.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class HeadphonesService {
    private static final Logger LOG = LoggerFactory.getLogger(HeadphonesService.class);

    public List<HeadphonesFacet> getHeadphonesFacetItems() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/facets/headphones";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        LOG.info("Response body: {}", responseBody.asString());
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "facets.general.items",
                HeadphonesFacet.class);
    }

    private Map<String, Object> configureRequestHeaders() {
        return Map.of("", "",
                "", "",
                "", "",
                "", "",
                "", "");
    }
}
