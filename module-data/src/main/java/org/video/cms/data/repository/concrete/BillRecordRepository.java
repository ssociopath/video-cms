package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.repository.DataRepository;

import java.util.List;

/**
 * @author bobo
 * @date 2020/12/15
 */

public interface BillRecordRepository  extends DataRepository<BillRecord,Integer> {
    List<BillRecord> findAllByMemberId(String id);
    BillRecord findBillRecordByRentId(int id);
}
