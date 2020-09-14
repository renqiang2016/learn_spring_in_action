package com.ren.taco_flux_web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/1 19:44
 */
@Data
@RestResource(rel = "tacos", path = "tacos")
@Document
public class Taco {

    @Id
    private String id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long.")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient.")
    private List<Ingredient> ingredients;

    private Date createdAt = new Date();

}
