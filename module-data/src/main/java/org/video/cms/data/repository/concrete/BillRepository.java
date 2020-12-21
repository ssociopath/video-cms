package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.Bill;
import org.video.cms.data.repository.DataRepository;

/**
 * @author bobo
 * @date 2020/12/20
 */

public interface BillRepository extends DataRepository<Bill, Integer> {
    Bill findById(int id);
}
