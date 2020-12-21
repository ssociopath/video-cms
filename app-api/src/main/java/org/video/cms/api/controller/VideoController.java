package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Video;
import org.video.cms.data.service.VideoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bobo
 * @date 2020/12/8
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/video")
public class VideoController {
    @Resource
    private VideoService videoService;

    @GetMapping("/findAll")
    public ApplicationResponse<List<Video>> getAll() {
        return ApplicationResponse.succeed("成功", videoService.getVideos());
    }

    @PostMapping("/findById")
    public ApplicationResponse<Video> getById(String id) {
        return ApplicationResponse.succeed("成功", videoService.getVideoById(id));
    }

    @PostMapping("/delete")
    public ApplicationResponse<Void> delete(String id) {
        videoService.deleteVideo(id);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/add")
    public ApplicationResponse<Void> add(Video video) {
        videoService.addVideo(video);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/update")
    public ApplicationResponse<Void> update(Video video) {
        videoService.updateVideo(video);
        return ApplicationResponse.succeed("成功");
    }

    @GetMapping("/ids")
    public ApplicationResponse<List<String>> getVideoId() {
        return ApplicationResponse.succeed("成功", videoService.getVideos().stream().map(Video::getVideoId).collect(Collectors.toList()));
    }
}
