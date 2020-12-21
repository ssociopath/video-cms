package org.video.cms.data.service;
import org.springframework.stereotype.Service;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.entity.Member;
import org.video.cms.data.entity.Video;
import org.video.cms.data.repository.concrete.VideoRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/8
 */

@Service
public class VideoService {
    @Resource
    private VideoRepository videoRepository;

    public List<Video> getVideos(){
        return videoRepository.findAll();
    }
    public Video getVideoById(String id){
        Video video = videoRepository.findVideoByVideoId(id);
        AssertUtils.notNull(video, "录像不存在");
        return video;
    }

    public void deleteVideo(String id){
        AssertUtils.notNull(id, "id不能为空");
        videoRepository.deleteById(id);
    }

    public void addVideo(Video video){
        Video oldVideo = videoRepository.findVideoByVideoId(video.getVideoId());
        AssertUtils.isNull(oldVideo, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该影片已存在！"));
        videoRepository.save(video);
    }

    public void updateVideo(Video video){
        AssertUtils.notNull(videoRepository.findVideoByVideoId(video.getVideoId()),  "该影片不存在！");
        videoRepository.save(video);
    }
}
