package com.demo.dao;

import com.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
//xiugai
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