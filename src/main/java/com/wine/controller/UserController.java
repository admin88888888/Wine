/*
package com.tasty.controller;



import com.tasty.common.JsonBean;
import com.tasty.entity.User;
import com.tasty.service.UserService;
import com.tasty.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Created by Administrator on 2019/5/4 0004.
 *//*

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("register.do")
    public JsonBean register(User user){

        int i = userService.register(user);
        if (i != 0){
            return JsonUtil.createJsonBean(1,null);
        }else {
            return JsonUtil.createJsonBean(0,null);
        }
    }


}
*/

package com.wine.controller;



import com.wine.common.Common;
import com.wine.common.JsonBean;
import com.wine.dao.UserDao;
import com.wine.entity.User;
import com.wine.service.CodeService;
import com.wine.service.UserService;
import com.wine.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Api(value = "用户模块",tags = "用户模块")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private UserDao userDao;
    @CrossOrigin
    @ApiOperation(value = "用户注册",notes = "用户注册")
    //注册
    @GetMapping("register.do")
    public JsonBean register(User user,String smscode){
        codeService.checkCode(user.getPhone(),smscode);
        int i = userService.register(user);
        if (i != 0){
            return JsonUtil.createJsonBean(1000,"注册成功",null);
        }else {
            return JsonUtil.createJsonBean(1001,"注册失败",null);
        }
    }
    @CrossOrigin
    @ApiOperation(value = "用户登录",notes = "用户登录")
    //登录
    @GetMapping("login.do")
    public JsonBean login(String name,String password,HttpSession session){
        User user = userService.login(name, password);
        session.setAttribute(Common.LOGIN_USER,user);
        return JsonUtil.createJsonBean(1000,"登录成功",null);
    }
    @CrossOrigin
    @ApiOperation(value = "更改用户名",notes = "更改用户名")
    @GetMapping("changePassword.do")
    public JsonBean changePassword(String name,String password,String newpassword){
        userService.changePassword(name,password, newpassword);
        return JsonUtil.createJsonBean(1000,"修改成功",null);
    }
    @CrossOrigin
    @ApiOperation(value = "个人用户信息修改",notes = "个人用户信息修改")
    @GetMapping("editUser.do")
    public JsonBean editUser(User user){
        userService.editUser(user);
        System.out.println(user);
        return JsonUtil.createJsonBean(1000,"修改成功",null);
    }
    @CrossOrigin
    @ApiOperation(value = "注销用户",notes = "注销用户")
    @GetMapping("deleteUser.do")
    public JsonBean deleteUser(String name){
        userService.deleteUser(name);
        return JsonUtil.createJsonBean(1000,"注销成功",null);
    }
    //退出登录
    @CrossOrigin
    @ApiOperation(value = "退出登录",notes = "退出登录")
    @GetMapping("offlogin.do")
    public JsonBean offlogin(HttpSession session){
        session.removeAttribute(Common.LOGIN_USER);
        return JsonUtil.createJsonBean(1000,"退出成功",null);
    }
    @CrossOrigin
    @ApiOperation(value = "返回所有user的信息",notes = "无需传值返回所有的User")
    @GetMapping("selectuserall.do")
    public JsonBean selectUserAll(){
            List<User> users = userService.selectUserAll();
        return JsonUtil.createJsonBean(1000,"返回成功",users);
    }
    @CrossOrigin
    @ApiOperation(value = "修改密码",notes = "请传入手机号和新密码")
    @GetMapping("updatepassword.do")
    public JsonBean selectUserAll(@RequestParam("phone") String phone,@RequestParam("password") String password){
        userService.updatePassword(phone,password);
        return JsonUtil.createJsonBean(1000,"修改成功",null);
    }

    @CrossOrigin
    @ApiOperation(value = "根据type查询",notes = "1是经销商，2是厂家")
    @GetMapping("selectByType.do")
    public JsonBean selectByType(int type){
        List<User> users = userService.selectByType(type);
        return JsonUtil.createJsonBean(1000,"返回成功",users);
    }

    @CrossOrigin
    @ApiOperation(value = "根据id获取用户信息",notes = "根据id获取用户信息")
    @PostMapping("selectUserById.do")
    public JsonBean selectUserById(HttpSession session){
        User user = (User)session.getAttribute(Common.LOGIN_USER);
        User user2 = userDao.selectUserById(user.getId());
        return JsonUtil.createJsonBean(1000,"OK",user);
    }

}

