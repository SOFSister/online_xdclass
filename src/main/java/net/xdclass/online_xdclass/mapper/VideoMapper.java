package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
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
 * @ClassName : VideoMapper.java
 * @createTime : 2022/3/1 15:05
 * @Email : 874280179@qq.com
 * @Description :
 */
@Mapper
public interface VideoMapper {

    /**
     * 视频列表查询
     * @return
     */
    List<Video> listVideo();

    /**
     * 视频轮播图列表查询
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询视频信息
     * @param videoId
     */
    Video findById(@Param("video_id") int videoId);
}
