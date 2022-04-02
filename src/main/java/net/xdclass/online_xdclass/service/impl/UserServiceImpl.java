package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.CommonUtils;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service.impl
 * @ClassName : UserServiceImpl.java
 * @createTime : 2022/3/6 12:10
 * @Email : 874280179@qq.com
 * @Description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int save(Map<String, String> userInfo) {
        User user= ParseToUser(userInfo);
        if(user != null){
            return userMapper.save(user);
        }else{
            return -1;
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        User user = userMapper.findByPhoneAndPwd(phone,CommonUtils.MD5(pwd));

        if(user == null){

            return null;

        }else{
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }

    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    /**
     * 解析User对象
     * @param userInfo
     * @return
     */
    private User ParseToUser(Map<String, String> userInfo) {

        if(userInfo.containsKey("name") && userInfo.containsKey("pwd") && userInfo.containsKey("phone")){

            User user = new User();
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());

            String pwd = userInfo.get("pwd");
            //MD5加密
            user.setPwd(CommonUtils.MD5(pwd));

            return user;

        }else{

            return null;

        }
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size = headImg.length;

        Random random = new Random();
        int index = random.nextInt(size);

        return headImg[index];
    }
}
