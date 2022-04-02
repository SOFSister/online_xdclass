package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.mapper
 * @ClassName : UserMapper.java
 * @createTime : 2022/3/6 12:07
 * @Email : 874280179@qq.com
 * @Description :
 */
@Mapper
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int save(User user);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findById(@Param("user_id") Integer id);
}
