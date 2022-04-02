package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service
 * @ClassName : UserService.java
 * @createTime : 2022/3/6 10:51
 * @Email : 874280179@qq.com
 * @Description :
 */
public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);


    String findByPhoneAndPwd(String phone, String pwd);

    User findById(Integer id);
}
