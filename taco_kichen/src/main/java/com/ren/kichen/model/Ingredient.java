package com.ren.kichen.model;

import lombok.Data;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 10:55
 */
@Data
public class Ingredient {
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
