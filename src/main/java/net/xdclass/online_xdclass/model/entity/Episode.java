package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.domain
 * @ClassName : Episode.java
 * @createTime : 2022/3/1 14:04
 * @Email : 874280179@qq.com
 * @Description :
 * CREATE TABLE `episode` (
 *   `id` int unsigned NOT NULL AUTO_INCREMENT,
 *   `title` varchar(524) DEFAULT NULL COMMENT '集标题',
 *   `num` int DEFAULT NULL COMMENT '第几集,全局顺序',
 *   `ordered` int DEFAULT NULL COMMENT '顺序，章里面的顺序',
 *   `play_url` varchar(256) DEFAULT NULL COMMENT '播放地址',
 *   `chapter_id` int DEFAULT NULL COMMENT '章节主键id',
 *   `free` tinyint DEFAULT '0' COMMENT '0表示免费，1表示首付',
 *   `video_id` int DEFAULT NULL COMMENT '视频id',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=12630 DEFAULT CHARSET=utf8mb3;
 */
public class Episode {

    private Integer id;

    private String title;

    private Integer num;

    private Integer ordered;

    @JsonProperty("play_url")
    private String playUrl;

    @JsonProperty("chapter_id")
    private Integer chapterId;

    private Integer free;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", ordered=" + ordered +
                ", playUrl='" + playUrl + '\'' +
                ", chapterId=" + chapterId +
                ", free=" + free +
                ", videoId=" + videoId +
                ", createTime=" + createTime +
                '}';
    }
}
