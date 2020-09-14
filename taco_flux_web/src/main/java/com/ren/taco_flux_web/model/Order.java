package com.ren.taco_flux_web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/1 20:49
 */
@Data
@Document
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Street is required.")
    private String street;

    @NotBlank(message = "City is required.")
    private String city;

    @NotBlank(message = "Status is required.")
    private String state;

    @NotBlank(message = "Zip code is required.")
    private String zip;

    private Date createdAt = new Date();

    private List<Taco> tacos = new ArrayList<>();

    @Field("customer")
    private User user;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}
