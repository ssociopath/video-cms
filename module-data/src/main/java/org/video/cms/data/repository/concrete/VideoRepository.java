package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.Video;
import org.video.cms.data.repository.DataRepository;

/**
 * @author bobo
 * @date 2020/12/8
 */

public interface VideoRepository extends DataRepository<Video,String> {
    Video findVideoByVideoId(String id);
}
