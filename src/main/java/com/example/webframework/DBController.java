package com.example.webframework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DBController {

    // Jdbc 자동 연동 annotation
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MovieMapper mapper;

    @RequestMapping("/create")
    public String create() {

        String sql = "DROP TABLE IF EXISTS movie; CREATE TABLE movie ( id INT auto_increment,  title VARCHAR(50), genre VARCHAR(50), img VARCHAR(50), actors VARCHAR(50), link VARCHAR(50))";
        // id, title, genre, img, actor, link
        // auto_increment로 인해, id 값 자동 증가

        jdbcTemplate.execute(sql);
        // sql 실행

        jdbcTemplate.update("INSERT INTO movie (title, genre) values('홍길동', 'animation')");
        jdbcTemplate.update("INSERT INTO movie (title, genre) values('웨스트사이드스토리', '뮤지컬')");
        jdbcTemplate.update("INSERT INTO movie (title, genre) values('특송', 'action')");
        // 항목 추가

        List<Movie> all =
                jdbcTemplate.query("select * from movie",
                        (rs, n) -> new Movie(
                                rs.getInt("id"),
                                rs.getString("title"))
                );
        // 테이블 출력

        List<Map<String,Object>> results = jdbcTemplate.queryForList("select * from movie");
        for (Map m : results) {
            System.out.println(m.get("title"));
        }
        // 위와 같은 형식. 특정 데이터를 찾을 때 좋음.

        return "테이블이 생성됨 : " + all;
        // all 내부적으로 toString()이 내장되어 있음.
    }

    @RequestMapping("/mybatis")
    public String mybatis() {
        List<Movie> list = mapper.selectAll();

        Movie m = mapper.select(2);
        // id 값이 2인 movie 객체 값을 반환
        System.out.println(m);

        // List<Movie> result = mapper.search("%abc");

        return list.toString();
    }
}
