package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.config.CacheKeyManager;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service.impl
 * @ClassName : VideoMapperImpl.java
 * @createTime : 2022/3/1 15:13
 * @Email : 874280179@qq.com
 * @Description :
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        try {
            //先去本地缓存里找
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST,()->{

                //回调 本地缓存内没有找到，去数据库找
                List<Video> videoList = videoMapper.listVideo();

                return videoList;

            });

            if(cacheObj instanceof List){

                List<Video> videoList = (List<Video>) cacheObj;

                return videoList;

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VideoBanner> listVideoBanner() {

        try {
            //先去本地缓存里找
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY,()->{

                //回调 本地缓存内没有找到，去数据库找
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();

                return bannerList;

            });

            if(cacheObj instanceof List){

                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;

                return bannerList;

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);

        try {
            //先去本地缓存里找
            Object cacheObj = baseCache.getOneHourCache().get(videoCacheKey,()->{

                //回调 本地缓存内没有找到，去数据库找
                Video video = videoMapper.findDetailById(videoId);

                return video;

            });

            if(cacheObj instanceof Video){

                Video video = (Video) cacheObj;

                return video;

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }


}
