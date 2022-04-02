package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Episode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.mapper
 * @ClassName : EpisodeMapper.java
 * @createTime : 2022/3/8 20:38
 * @Email : 874280179@qq.com
 * @Description :
 */
@Mapper
public interface EpisodeMapper {

    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);

}
