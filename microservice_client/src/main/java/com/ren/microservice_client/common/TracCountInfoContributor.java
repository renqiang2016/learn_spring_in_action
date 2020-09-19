package com.ren.microservice_client.common;

import com.ren.microservice_client.model.Ingredient;
import com.ren.microservice_client.service.IngredientServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 为actuator/info提供更多信息
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/18 14:39
 */
@Component
public class TracCountInfoContributor implements InfoContributor {
    private IngredientServiceClient client;

    @Autowired
    public TracCountInfoContributor(IngredientServiceClient client) {
        this.client = client;
    }

    @Override
    public void contribute(Info.Builder builder) {
        long tacoCount = 0;
        /*
        Iterable<Ingredient> ingredients = client.getAllIngredients();
        while (ingredients.iterator().hasNext()) {
            ingredients.iterator().next();
            tacoCount++;
        }
         */
        Map<String, Object> tacoMap = new HashMap<>();
        tacoMap.put("count", tacoCount);
        builder.withDetail("taco-stats", tacoMap);
    }
}
