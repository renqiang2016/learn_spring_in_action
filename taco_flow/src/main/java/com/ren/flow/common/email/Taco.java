package com.ren.flow.common.email;

import lombok.Data;

import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:39
 */
@Data
public class Taco {

    private final String name;
    private List<String> ingredients;

}
