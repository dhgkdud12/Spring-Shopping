package com.example.webframework;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class APIController {
    List<Product> products = new ArrayList();

    public APIController() {
        products.add(new Product(1, "모자"));
        products.add(new Product(2, "안경"));
        products.add(new Product(3, "티셔츠"));
    }


    @RequestMapping("/getproducts")
    public Map getmovie() {
        Map<String, Object > map= new HashMap();
        map.put("title", "쇼핑몰 사이트");
        map.put("addres", "경기도 수원시");
        map.put("products", products);
        return  map;
    }
}
