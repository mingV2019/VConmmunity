package com.vcommunity.mapper;

import com.vcommunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/18 23:47
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified}) ")
    void insert(User user);
}
