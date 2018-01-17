package com.demo.dao;

import com.demo.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUsercode() != null) {
            sql.VALUES("userCode", "#{usercode,jdbcType=INTEGER}");
        }
        
        if (record.getMobilenumber() != null) {
            sql.VALUES("mobileNumber", "#{mobilenumber,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getMobilenumber() != null) {
            sql.SET("mobileNumber = #{mobilenumber,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("userCode = #{usercode,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}