package com.napptilus.willywonka.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Response Dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OLResponse {

    /**
     * Property Name
     */
    private String name;

    /**
     * Property Age
     */
    private Short age;

    /**
     * Property Job Title
     */
    private String jobTitle;

    /**
     * Property Height
     */
    private Float height;

    /**
     * Property Weight
     */
    private Float weight;

    /**
     * Property Description
     */
    private String description;
}
