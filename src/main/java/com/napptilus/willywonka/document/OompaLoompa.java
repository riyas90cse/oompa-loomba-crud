package com.napptilus.willywonka.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Document Object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "oompaloompa")
public class OompaLoompa {

    /**
     * Property ID
     */
    @Id
    private String id;

    /**
     * Property NAME
     */
    private String name;

    /**
     * Property AGE
     */
    private short age;

    /**
     * Property JOB(Title or Designation)
     */
    private String jobTitle;

    /**
     * Property HEIGHT
     */
    private float height;

    /**
     * Property WEIGHT
     */
    private float weight;

    /**
     * Property DESCRIPTION
     */
    private String description;

    /**
     * Property CREATED AT(DATE CREATED)
     */
    @ApiModelProperty(hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date createdAt;

    /**
     * Property UPDATED AT(DATE UPDATED)
     */
    @ApiModelProperty(hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date updatedAt;
}
