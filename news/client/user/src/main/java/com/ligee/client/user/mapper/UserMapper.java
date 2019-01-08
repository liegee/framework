package com.ligee.client.user.mapper;

import com.ligee.client.user.model.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:18 PM
 */
@Mapper
@Service
public interface UserMapper {

    @Select("select id,mobile,password from news_user where mobile = #{mobile} and password = #{password}")
    UserBean selectUser(@Param("mobile") String mobile, @Param("password") String password);

    @Select("select id,mobile,password from news_user where mobile = #{mobile}")
    UserBean selectUser(String mobile);

    @Insert("insert into news_user(gmt_create, gmt_modified, mobile, password) values(now(), now(), #{mobile}, #{password})")
    int insertUser(UserBean userBean);
}
