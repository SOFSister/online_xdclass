package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.domain
 * @ClassName : User.java
 * @createTime : 2022/3/1 14:12
 * @Email : 874280179@qq.com
 * @Description :
 * CREATE TABLE `user` (
 *   `id` int unsigned NOT NULL AUTO_INCREMENT,
 *   `name` varchar(128) DEFAULT NULL COMMENT '昵称',
 *   `pwd` varchar(124) DEFAULT NULL COMMENT '密码',
 *   `head_img` varchar(524) DEFAULT NULL COMMENT '头像',
 *   `phone` varchar(64) DEFAULT '' COMMENT '手机号',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
 */
public class User {

    private Integer id;

    private String name;

    @JsonIgnore
    private String pwd;

    @JsonProperty("head_img")
    private String headImg;

    private String phone;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
