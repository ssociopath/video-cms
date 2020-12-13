package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.id.CopyPk;
import org.video.cms.data.repository.DataRepository;

/**
 * @author bobo
 * @date 2020/12/8
 */

public interface CopyRepository extends DataRepository<Copy, CopyPk> {
    Copy findCopyByCopyPkVideoIdAndCopyPkCopyId(String videoId, int copyId);
}
