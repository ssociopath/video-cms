package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.RentRecord;
import org.video.cms.data.repository.DataRepository;

import java.util.List;

/**
 * @author bobo
 * @date 2020/12/13
 */

public interface RentRecordRepository extends DataRepository<RentRecord,Integer> {
    RentRecord findRentRecordByRentId(int id);
    List<RentRecord> findAllByMemberId(String memberId);
}
