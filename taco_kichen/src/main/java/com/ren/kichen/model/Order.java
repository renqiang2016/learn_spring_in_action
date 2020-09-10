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
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;

    private List<Taco> tacos = new ArrayList<>();
}
