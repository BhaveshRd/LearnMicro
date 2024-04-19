package com.apigateway.customroute;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class CustomRouteConfiguration {

    //adding custom filters on specific parts.
    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){

        //Default router
      //  return  builder.routes().build();

        // if i get anything with /get it will redirect to uri
        Function<PredicateSpec, Buildable<Route>> routeFunction1 =
                p -> p.path("/get")
                        .filters( f-> f.addRequestHeader("myHeader", "headerValue")
                                .addRequestParameter("myParam", "paramValue"))
                        .uri("http://httpbin.org:80");

        Function<PredicateSpec, Buildable<Route>> routeFunction2 =
                p -> p.path("/dealer/**")
                        .uri("lb://dealer-service");

        Function<PredicateSpec, Buildable<Route>> routeFunction3 =
                p -> p.path("/car_service/**")
                        .uri("lb://car-service");


        //Here im replace /car_service with /car
        Function<PredicateSpec, Buildable<Route>> routeFunction4 =
                p->p.path("/car/**")
                        .filters( f->f.rewritePath(
                                "/car/(?<segment>.*)",
                                "/car_service/${segment}"
                        )).uri("lb://car-service");


        return builder.routes()
                .route(routeFunction1)
                .route(routeFunction2)
                .route(routeFunction3)
                .route(routeFunction4)
                .build();


    }
}
