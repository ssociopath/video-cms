package org.video.cms.api.module.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.Member;
import org.video.cms.data.entity.id.CopyPk;

/**
 * @author bobo
 * @date 2020/12/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CopyVO {
    private String videoId;
    private int copyId;
    private String status;

    public static CopyVO fromCopy(Copy copy) {
        String statusStr="";
        if(copy.getStatus()== '1' ){
            statusStr="可被租借";
        }else{
            statusStr="已被租借";
        }
        return CopyVO.builder()
                .videoId(copy.getCopyPk().getVideoId())
                .copyId(copy.getCopyPk().getCopyId())
                .status(statusStr)
                .build();
    }

    public Copy toCopy() {
        return Copy.builder()
                .copyPk(new CopyPk(videoId, copyId))
                .status("可被租借".equals(status) ? '1':'0')
                .build();
    }
}
