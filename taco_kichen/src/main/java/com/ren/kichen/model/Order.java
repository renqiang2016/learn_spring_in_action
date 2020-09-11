package com.ren.kichen.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 10:53
 */
@Data
public class Order {
    private Date createdAt;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    private List<Taco> tacos = new ArrayList<>();
}
