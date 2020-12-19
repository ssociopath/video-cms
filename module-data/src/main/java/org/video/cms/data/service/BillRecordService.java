package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.repository.concrete.BillRecordRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/15
 */
@Service
@Slf4j
public class BillRecordService {
    @Resource
    BillRecordRepository billRecordRepository;
    public List<BillRecord> getBillRecord(){
        return billRecordRepository.findAll();
    }
}
