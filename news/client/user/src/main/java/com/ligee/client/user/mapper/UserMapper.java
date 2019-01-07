package com.ligee.client.user.mapper;

import com.ligee.client.user.model.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:18 PM
 */
@Mapper
@Service
public interface UserMapper {

    @Select("select id,mobile,password from news_user where mobile = #{mobile} and password = #{password}")
    List<UserBean> selectUser(String mobile, String password);

    @Select("select id,mobile,password from news_user where mobile = #{mobile}")
    List<UserBean> selectUser(String mobile);
}
