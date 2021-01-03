package com.napptilus.willywonka.config;

import com.napptilus.willywonka.helper.AuthHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Web Configuration Component
 */
@Configuration
public class WebConfig implements WebFluxConfigurer {

    /**
     * Property Origins
     */
    @Value("${napptilus.app.origins}")
    private String[] origins;

    /**
     * Cors Mapping Method
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(origins)
                .allowCredentials(Boolean.TRUE)
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders(
                        "Access-Control-Allow-Headers",
                        "Access-Control-Expose-Headers",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Origin",
                        "Cache-Control",
                        "Content-Type",
                        "Authorization")
                .exposedHeaders(AuthHelper.HEADER_NAME);
    }
}
