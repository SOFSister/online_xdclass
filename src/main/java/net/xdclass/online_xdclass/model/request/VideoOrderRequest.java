package net.xdclass.online_xdclass.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.model.request
 * @ClassName : VideoOrderRequest.java
 * @createTime : 2022/3/8 14:16
 * @Email : 874280179@qq.com
 * @Description :
 */
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
