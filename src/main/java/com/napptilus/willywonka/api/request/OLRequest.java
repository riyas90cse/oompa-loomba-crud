package com.napptilus.willywonka.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Request DTO Object
 */
@Getter
@Setter
public class OLRequest {

    /**
     * Property Name
     */
    @ApiModelProperty(notes = "Name", example = "Mark Twain", required = true, position = 1)
    private String name;

    /**
     * Property Age
     */
    @ApiModelProperty(notes = "Age", example = "32", required = true, position = 2)
    private short age;

    /**
     * Property Job Tilte
     */
    @ApiModelProperty(notes = "Job Title", example = "Factory Supervisor", required = true, position = 3)
    private String jobTitle;

    /**
     * Property Height
     */
    @ApiModelProperty(notes = "Height in inches", example = "5.2", required = true, position = 4)
    private float height;

    /**
     * Property Weight
     */
    @ApiModelProperty(notes = "Weight in pounds", example = "150", required = true, position = 5)
    private float weight;

    /**
     * Property description
     */
    @ApiModelProperty(notes = "Description", example = "Serving legend in Willy Wonka's chocolate factory", position = 6)
    private String description;
}
