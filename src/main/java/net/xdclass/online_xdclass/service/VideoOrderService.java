package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service
 * @ClassName : VideoOrderService.java
 * @createTime : 2022/3/8 14:33
 * @Email : 874280179@qq.com
 * @Description :
 */
public interface VideoOrderService {

    int save(int userId,int videoId);

    List<VideoOrder> listOrderByUserId(int userId);
}
