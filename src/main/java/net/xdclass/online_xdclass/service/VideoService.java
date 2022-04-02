package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service
 * @ClassName : VideoService.java
 * @createTime : 2022/3/1 15:11
 * @Email : 874280179@qq.com
 * @Description :
 */
public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
