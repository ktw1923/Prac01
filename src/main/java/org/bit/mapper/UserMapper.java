package org.bit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bit.model.User;

@Mapper
public interface UserMapper {
    User findByEmail(String email);
    void insertUser(User user);
}