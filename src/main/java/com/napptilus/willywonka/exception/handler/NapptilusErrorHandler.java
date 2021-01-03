package com.napptilus.willywonka.exception.handler;

import com.napptilus.willywonka.api.response.ErrorResponse;
import com.napptilus.willywonka.exception.NapptilusException;
import com.napptilus.willywonka.exception.NapptilusServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Error Handle Controller Advice
 */
@ControllerAdvice
@Slf4j
public class NapptilusErrorHandler {

    /**
     * Exception Handling Not Found Method
     * @param req httpservlet req
     * @param ne napptilus custom exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NapptilusException.class)
    @ResponseBody
    public ErrorResponse handleNapptilusException(HttpServletRequest req, NapptilusException ne) {
        LOG.info("NapptilusException {}", ne.getMessage());
        return ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).message(HttpStatus.NOT_FOUND.getReasonPhrase()).details(ne.getMessage()).build();
    }

    /**
     * Exception Handling Internal Server Error Method
     * @param nse naptilus server customer exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NapptilusServerException.class)
    @ResponseBody
    public ErrorResponse handleNapptilusServerException(NapptilusServerException nse) {
        LOG.info("NapptilusServerException {}", nse.getMessage());
        return ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).details(nse.getMessage()).build();
    }

    /**
     * Exception Handling Internal Server error
     * @param ex Exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleException(Exception ex) {
        LOG.info("Exception {}", ex.getMessage());
        return ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).details(ex.getMessage()).build();
    }

}
