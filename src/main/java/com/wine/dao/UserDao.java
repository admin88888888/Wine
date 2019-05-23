/*
package com.tasty.dao;

import com.tasty.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



*/
/**
 * Created by Administrator on 2019/5/4 0004.
 *//*

@Mapper
public interface UserDao {
    @Select("select * from user where name = #{name}")
    public User register(String name);
    @Insert("insert into user (name,password,phone,email,type,flag) values (#{name},#{password},#{phone},#{email},#{type},1)")
    public int addUser(User user);
}
*/

package com.wine.dao;
import com.wine.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
public interface UserDao {
    int save();
    @Select("select * from user where name = #{name}")
    public User register(String name);
    @Insert("insert into user (name,password,phone,email,type,flag) values (#{name},#{password},#{phone},#{email},#{type},1)")
    public int addUser(User user);
    @Update("update user set password = #{newpassword} where name = #{name}")
    void changePassword(@Param("name") String name,@Param("newpassword") String newpassword);
    @Select("select password from user where name = #{name} ")
    String findOldPassword(String name);
    @Select("select * from user where type = #{type}")
    List<User> selectByType(int type);
    void editUser(User user);
    @Delete("delete from user where name = #{name}")
    void deleteUser(String name);
    //返回所有用户信息
    @Select("select * from user")
    List<User> selectUserAll();
    //updata密码根据手机号
    @Update("update user set password = #{password} where phone = #{phone}")
    void updatePassword(@Param("phone") String phone,@Param("password") String password);

    @Select("select * from user where phone = #{phone}")
    User selectUserByPhone(@Param("phone") String phone);

    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    void updateByPrimaryKeySelective(User user);
}

