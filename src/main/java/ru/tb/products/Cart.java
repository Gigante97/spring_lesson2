package ru.tb.products;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@Component
@Scope("prototype")
public class Cart {
    private final Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap(){
        return cartMap;
    }
    public void addProduct(Product product, Integer id){
            if (product != null) {
                cartMap.merge(product, id,Integer::sum);
            }
    }
    public void deleteProduct(Product product, Integer id) {
        if (cartMap.containsKey(product)) {
            if (id != null && cartMap.get(product).compareTo(id) >0) {
                cartMap.put(product,cartMap.get(product)-id);
            } else {
                cartMap.remove(product);
            }
        }
    }
    public BigDecimal getSum() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            sum = sum.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return sum;
    }

}
