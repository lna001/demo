package com.demo.mapper;

import com.demo.dao.UserSqlProvider;
import com.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where userCode = #{usercode,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer usercode);

    @Insert({
        "insert into user (userCode, mobileNumber, ",
        "name)",
        "values (#{usercode,jdbcType=INTEGER}, #{mobilenumber,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "userCode, mobileNumber, name",
        "from user",
        "where userCode = #{usercode,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userCode", property="usercode", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mobileNumber", property="mobilenumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer usercode);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set mobileNumber = #{mobilenumber,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where userCode = #{usercode,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}