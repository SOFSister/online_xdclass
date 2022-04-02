package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.mapper
 * @ClassName : VideoOrderMapper.java
 * @createTime : 2022/3/8 14:44
 * @Email : 874280179@qq.com
 * @Description :
 */
@Mapper
public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此商品
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 订单存入数据库
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 根据用户id查询订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") int userId);
}
