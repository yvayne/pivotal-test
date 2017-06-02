package org.fundacionjala.pivotal.utils.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * Created by Administrator on 5/25/2017.
 */
public final class RestConnection {
    private static RestConnection instance;
    private RequestSpecification requestSpecification;

    /**
     * The constructor constructs an specific request, using all the next
     * common parameters: proxy, header and baseUri.
     */
    private RestConnection() {
        requestSpecification = new RequestSpecBuilder()
                .setProxy(Environment.getInstance()
                                .getPropertyValue("testerAt03.proxyIp"),
                        Integer.parseInt(Environment.getInstance()
                                .getPropertyValue("testerAt03.proxyPort")))
                .addHeader("X-TrackerToken",
                        Environment.getInstance()
                                .getPropertyValue("testerAt03.apiToken"))
                .setBaseUri(Environment.getInstance()
                        .getPropertyValue("testerAt03.baseURI"))
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
