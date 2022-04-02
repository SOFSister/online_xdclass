package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.controller
 * @ClassName : VideoController.java
 * @createTime : 2022/3/1 15:17
 * @Email : 874280179@qq.com
 * @Description :
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo(){

        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);

    }

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData listVideoBanner(){

        List<VideoBanner> videoBannerList = videoService.listVideoBanner();

        return JsonData.buildSuccess(videoBannerList);
    }

    /**
     * 查询视频信息，包含章、集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true) int videoId){

        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);

    }
}
