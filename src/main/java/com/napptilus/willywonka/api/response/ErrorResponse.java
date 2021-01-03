package com.napptilus.willywonka.api.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Error Response Dto
 */
@Data
@Builder
public class ErrorResponse {

    /**
     * Property HTTP Status Error Code
     */
    private int status;

    /**
     * Property Error Message
     */
    private String message;

    /**
     * Property Detailed Message
     */
    private String details;
}
