package org.video.cms.data.service;

import org.springframework.stereotype.Service;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.Video;
import org.video.cms.data.entity.id.CopyPk;
import org.video.cms.data.repository.concrete.CopyRepository;
import org.video.cms.data.repository.concrete.VideoRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/8
 */

@Service
public class CopyService {
    @Resource
    private CopyRepository copyRepository;
    @Resource
    private VideoRepository videoRepository;

    public List<Copy> getCopies(){
        return copyRepository.findAll();
    }

    public void deleteCopy(CopyPk id){
        AssertUtils.notNull(id, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_MISSING, "id不能为空"));
        Video video = videoRepository.findVideoByVideoId(id.getVideoId());
        copyRepository.deleteById(id);
        video.setStock(video.getStock()-1);
        videoRepository.save(video);
    }

    public void addCopy(Copy copy){
        Copy oldCopy = copyRepository.findCopyByCopyPkVideoIdAndCopyPkCopyId(copy.getCopyPk().getVideoId(),copy.getCopyPk().getCopyId());
        AssertUtils.isNull(oldCopy, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该拷贝已存在！"));
        Video video = videoRepository.findVideoByVideoId(copy.getCopyPk().getVideoId());
        copyRepository.save(copy);
        video.setStock(video.getStock()+1);
        videoRepository.save(video);
    }

    public void updateCopy(int oldCopyId, Copy copy){
        Copy oldCopy = copyRepository.findCopyByCopyPkVideoIdAndCopyPkCopyId(copy.getCopyPk().getVideoId(),oldCopyId);
        AssertUtils.notNull(oldCopy,  "该拷贝不存在！");
        AssertUtils.isNull(copyRepository.findCopyByCopyPkVideoIdAndCopyPkCopyId(copy.getCopyPk().getVideoId(),copy.getCopyPk().getCopyId()), ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该拷贝已存在！"));
        copyRepository.delete(oldCopy);
        copyRepository.save(copy);
    }
}
