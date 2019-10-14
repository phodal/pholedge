package com.phodal.pholedge.mapper;

import com.phodal.pholedge.book.model.Book;
import com.phodal.pholedge.book.model.BookRepresentaion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper {
    @Insert("INSERT INTO book (id, isbn, name, createdAt) VALUES (#{id}, #{isbn}, #{name}, #{createdAt})")
    int doSave(Book book);

    @Select("select * from book order by id")
    List<BookRepresentaion> list();

    @Select("select * from book where id = #{id}")
    Book byId(String id);
}
