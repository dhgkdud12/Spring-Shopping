package com.example.webframework;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// Mybatis(DB)와 java class 자동 연동
@Mapper
public interface ProductMapper {

    @Select("select * from product") // 향후 XML로 변경
    public List<Product> selectAll(); // movie 테이블의 모든 엔티티 검색

    @Select("select * from product where id = #{id}") //동적 바인딩
    // id 값을 자동으로 넣어 해당 엔티티 출력. select(int id)를 호출하면 자동으로 sql 실행
    public Product select(int id);    // id로 특정 영화만 검색

    @Select("select * from product where title like '#{keyword}'")
    // %abc : 끝단어가 abc인, %abc% : abc가 중간 단어인
    public List<Product> search(String keyword);

}
