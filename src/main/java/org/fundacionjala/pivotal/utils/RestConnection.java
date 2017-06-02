package org.fundacionjala.pivotal.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Created by Administrator on 5/25/2017.
 */
public final class RestConnection {
    private static int proxyPort = Integer.parseInt(Environment.getInstance()
            .getPropertyValue("testerAt03.proxyPort"));
    private static String proxyIp = Environment.getInstance()
            .getPropertyValue("testerAt03.proxyIp");
    private static String apiToken = Environment.getInstance()
            .getPropertyValue("testerAt03.apiToken");
    private static String baseURI = Environment.getInstance()
            .getPropertyValue("testerAt03.baseURI");
    private static RestConnection instance;
    private RequestSpecification requestSpecification;

    /**
     * The constructor constructs an specific request, using all the next
     * common parameters: proxy, header and baseUri.
     */
    private RestConnection() {
        requestSpecification = new RequestSpecBuilder()
                .setProxy(proxyIp, proxyPort)
                .addHeader("X-TrackerToken", apiToken)
                .setBaseUri(baseURI)
                .build();
    }

    /**
     * @return the RestConnection instance.
     */
    public static RestConnection getInstance() {
        if (instance == null) {
            instance = new RestConnection();
        }
        return instance;
    }

    /**
     * @return a request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
