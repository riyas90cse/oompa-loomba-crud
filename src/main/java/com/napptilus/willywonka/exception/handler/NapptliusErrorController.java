package com.napptilus.willywonka.exception.handler;

import com.napptilus.willywonka.api.response.ErrorResponse;
import com.napptilus.willywonka.core.SwaggerNegated;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Napptilus Error Controller
 */
@RestController
@SwaggerNegated
public class NapptliusErrorController implements ErrorController {

    /**
     * Get Error Path
     * @return String
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * Error Method
     * @param resp httpservlet response
     * @return Error Response
     */
    @RequestMapping("/error")
    public ErrorResponse error(HttpServletResponse resp) {
        return ErrorResponse.builder().status(resp.getStatus()).message("We regret. Some issue occurred").details("Page not found in the application. It could be bad request or internal server error").build();
    }
}
