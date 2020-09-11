package com.ren.flow.common.email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:40
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient {

    private final String code;
    private final String name;

}
