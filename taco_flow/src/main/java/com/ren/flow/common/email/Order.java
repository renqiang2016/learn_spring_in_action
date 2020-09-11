package com.ren.flow.common.email;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:39
 */
@Data
public class Order {

    private final String email;
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}
