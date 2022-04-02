package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.exception.XDException;
import net.xdclass.online_xdclass.mapper.*;
import net.xdclass.online_xdclass.model.entity.Episode;
import net.xdclass.online_xdclass.model.entity.PlayRecord;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.service.impl
 * @ClassName : VideoOrderServiceImpl.java
 * @createTime : 2022/3/8 14:35
 * @Email : 874280179@qq.com
 * @Description :
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 保存订单信息
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {

        //判断是否购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder != null){return 0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        //生成播放记录
        if(rows == 1){

            Episode episode = episodeMapper.findFirstEpisodeByVideoId(newVideoOrder.getVideoId());
            if(episode == null){
                throw new XDException(-1,"视频没有集信息，请运营人员检查");
            }


            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setVideoId(newVideoOrder.getVideoId());
            playRecord.setUserId(userId);
            playRecord.setCurrentNum(1);
            playRecord.setEpisodeId(episode.getId());

            playRecordMapper.save(playRecord);
        }

        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(int userId) {

        List<VideoOrder> videoOrderList = videoOrderMapper.listOrderByUserId(userId);

        return videoOrderList;
    }
}
