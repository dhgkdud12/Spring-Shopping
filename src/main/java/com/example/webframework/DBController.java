package com.example.webframework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DBController {

    // Jdbc 연동 annotation
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductMapper mapper;

    @RequestMapping("/create")
    public String create() {

        String sql = "DROP TABLE IF EXISTS product; CREATE TABLE product ( id INT auto_increment,  category VARCHAR(50), img VARCHAR(50), name VARCHAR(50), size VARCHAR(50), price INT(10))";

        jdbcTemplate.execute(sql);
        // sql 실행

        jdbcTemplate.update("INSERT INTO product (id, category, name) values(1,'accessory', '모자')");
        jdbcTemplate.update("INSERT INTO product (id, category, name) values(2,'accessory', '안경')");
        jdbcTemplate.update("INSERT INTO product (id, category, name) values(3,'top', '티셔츠')");
        // 항목 추가

        List<Product> all =
                jdbcTemplate.query("select * from product",
                        (rs, n) -> new Product(
                                rs.getInt("id"),
                                rs.getString("name"))
                );
        // 테이블 출력

        List<Map<String,Object>> results = jdbcTemplate.queryForList("select * from product");
        for (Map m : results) {
            System.out.println(m.get("모자"));
        }
        // 위와 같은 형식. 특정 데이터를 찾을 때 좋음.

        return "테이블이 생성됨 : " + all;
        // all 내부적으로 toString()이 내장되어 있음.
    }

    @RequestMapping("/mybatis")
    public String mybatis() {
        List<Product> list = mapper.selectAll();

        Product m = mapper.select(2);
        // id 값이 2인 movie 객체 값을 반환
        System.out.println(m);

        // List<Movie> result = mapper.search("%abc");

        return list.toString();
    }
}
