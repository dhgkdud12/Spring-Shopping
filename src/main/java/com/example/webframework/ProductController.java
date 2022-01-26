package com.example.webframework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1,"accessory","hat.jpg","모자","FREE",10000));
        products.add(new Product(2,"accessory","glasses.jpg","안경","FREE",5000));

        products.add(new Product(3,"top","T-shirts.jpg","티셔츠","FREE",20000));

        products.add(new Product(4,"bottom","pants.jpg","청바지","FREE",30000));

        products.add(new Product(5,"shoes","shoes.jpg","슬리퍼","240",40000));
    }

    @RequestMapping("/product")
    public String product(Model model){
//        model.addAttribute("title","강남대1호점");
        model.addAttribute("address","경기도 용인시");

        List<Product> accessory = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().equals("accessory"))
                accessory.add(product);
        }
        List<Product> top = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().equals("top"))
                top.add(product);
        }

        List<Product> bottom = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().equals("bottom"))
                bottom.add(product);
        }

        List<Product> shoes = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().equals("shoes"))
                shoes.add(product);
        }


        model.addAttribute("accessory", accessory);
        model.addAttribute("top", top);
        model.addAttribute("bottom", bottom);
        model.addAttribute("shoes", shoes);

        return "product";

    }


    @RequestMapping("/add_commit")
    public String add_commit(@ModelAttribute Product product) {
        products.add(product);
        return "redirect:/product";
    }

    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping("/signup_commit")
    public String signup_commit() {
        return "redirect:/product";
    }

}
