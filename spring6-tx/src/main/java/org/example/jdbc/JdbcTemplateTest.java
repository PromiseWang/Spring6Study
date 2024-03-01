package org.example.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Author: Promise
 * Date: 2024-02-19 18:50
 * Description:
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate1() {
        // 1. 添加
        // 1.1 编写SQL语句
        String sql = "INSERT INTO t_emp VALUES (NULL, ?, ?, ?)";
        // 1.2 调用jdbcTemplate方法, 传入相关参数
        // int rows = jdbcTemplate.update(sql, "张三", 20, "男");  // 影响行数
        // System.out.println(rows);

        // Object[] role = {"李四", 30, "女"};
        // System.out.println(jdbcTemplate.update(sql, role));

        Object[] role = {"王五", 35, "女"};
        System.out.println(jdbcTemplate.update(sql, role));
    }

    @Test
    public void testUpdate2() {
        // 2. 修改
        String sql = "UPDATE t_emp SET name=? WHERE id=?";
        int rows = jdbcTemplate.update(sql, "Wang Wu", 3);
        System.out.println(rows);
    }

    @Test
    public void testUpdate3() {
        // 3. 删除
        String sql = "DELETE from t_emp where id=?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);
    }

    @Test
    public void testReturnObject() {
        // 4.1 查询: 返回对象  写法1
        String sql = "SELECT * FROM t_emp WHERE id=?";
        Object o = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 1);
        System.out.println(o);
    }

    @Test
    public void testReturnObject2() {
        // 4.1 查询: 返回对象  写法2
        String sql = "SELECT * FROM t_emp WHERE id=?";
        Object o = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(o);
    }

    @Test
    public void testReturnList() {
        // 4.2 查询: 返回List
        String sql = "SELECT * FROM t_emp";
        List<Emp> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(result);
    }

    @Test
    public void testReturnValue() {
        String sql = "SELECT COUNT(*) FROM t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}
