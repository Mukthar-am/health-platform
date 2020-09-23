package com.platform.services.services;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.platform.services.configurations.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


/**
 * Author: mukthar.am@gmail.com (personal usage)
 * Date: 14-Jan-2020
 *
 * Usage: https://localhost:8443/pl-rest/welcome/status
 *
 */
@Slf4j
@Path("/welcome")
@Produces(MediaType.APPLICATION_JSON)
public class WelcomeService {
    final static Logger logger = LoggerFactory.getLogger(WelcomeService.class);
    private Configuration configurations;
    private final Validator validator;
    private HealthCheckRegistry registry;

    public WelcomeService(Validator validator, Configuration configs, HealthCheckRegistry registry) {
        this.validator = validator;
        this.configurations = configs;
        this.registry = registry;
    }

    @GET
    @Path("/status")
    public Set<Map.Entry<String, HealthCheck.Result>> getStatus() {
        // return health check entry sets
        return registry.runHealthChecks().entrySet();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response connectionSanity(@Context UriInfo queryParams) throws IOException {
        String responseStr = "{\"message\": \"welcome to the platform services\"}";
        return Response.ok(responseStr).build();
    }

}