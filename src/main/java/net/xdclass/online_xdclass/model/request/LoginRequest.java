package net.xdclass.online_xdclass.model.request;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.model.request
 * @ClassName : LoginRequest.java
 * @createTime : 2022/3/6 19:43
 * @Email : 874280179@qq.com
 * @Description :登录request
 */
public class LoginRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
