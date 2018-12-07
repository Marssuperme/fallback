package com.example.demo.mapper;

import com.example.demo.entities.TUser;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {

    @Select("select user_id, user_name, sex from t_user where user_id = #{userId,jdbcType=VARCHAR}")
    TUser selectByPrimaryKey(String userId);

    @Select("select user_id, user_name, sex from t_user ")
    TUser selectAll();

    @Delete("delete from t_user where user_id = #{userId,jdbcType=VARCHAR}")
    int deleteByPrimaryKey(String userId);


    @Insert({
        "insert into t_user (user_id, user_name, sex)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR})"
    })
    int insert(TUser record);

    @Update({
        "update t_user",
        "set user_name = #{userName,jdbcType=VARCHAR}, sex = #{sex,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TUser record);
}