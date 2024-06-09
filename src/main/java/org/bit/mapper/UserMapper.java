package org.bit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bit.model.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (email, password) VALUES (#{email}, #{password})")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User getUserByEmail(String email);
}
