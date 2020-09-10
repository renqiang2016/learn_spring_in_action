package com.ren.kichen.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 10:53
 */
@Data
public class Taco {

    private String name;

    private Date createdAt;

    private List<Ingredient> ingredients;
}
