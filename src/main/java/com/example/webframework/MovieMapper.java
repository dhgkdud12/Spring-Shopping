package com.example.webframework;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// Mybatis(DB)와 java class 자동 연동
@Mapper
public interface MovieMapper {

    @Select("select * from movie") // 향후 XML로 변경
    public List<Movie> selectAll(); // movie 테이블의 모든 엔티티 검색

    @Select("select * from movie where id = #{id}") //동적 바인딩
    // id 값을 자동으로 넣어 해당 엔티티 출력. select(int id)를 호출하면 자동으로 sql 실행
    public Movie select(int id);    // id로 특정 영화만 검색

    @Select("select * from movie where title like '#{keyword}'")
    // %abc : 끝단어가 abc인, %abc% : abc가 중간 단어인
    public List<Movie> search(String keyword);

}
