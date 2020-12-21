package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.common.utils.DateUtil;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.RentRecord;
import org.video.cms.data.entity.Video;
import org.video.cms.data.repository.concrete.BillRecordRepository;
import org.video.cms.data.repository.concrete.CopyRepository;
import org.video.cms.data.repository.concrete.RentRecordRepository;
import org.video.cms.data.repository.concrete.VideoRepository;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/13
 */
@Service
@Slf4j
public class RentRecordService {
    @Resource
    private RentRecordRepository rentRecordRepository;
    @Resource
    private CopyRepository copyRepository;

    public List<RentRecord> getRentRecords(){
        return rentRecordRepository.findAll();
    }

    public List<RentRecord> getRentRecordsByMemberId(String memberId){
        return rentRecordRepository.findAllByMemberId(memberId);
    }

    public RentRecord getRentRecordsByRentId(String id){
        return rentRecordRepository.findById(Integer.valueOf(id)).orElse(null);
    }


    public void addRentRecord(RentRecord rentRecord){
        RentRecord oldRentRecord = rentRecordRepository.findRentRecordByRentId(rentRecord.getRentId());
        AssertUtils.isNull(oldRentRecord, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该租借记录已存在！"));
        Copy copy = copyRepository.findCopyByCopyPkVideoIdAndCopyPkCopyId(rentRecord.getVideoId(),rentRecord.getCopyId());
        AssertUtils.isFalse(copy.getStatus()=='0'&&rentRecord.getDateReturned()==null,"该录像正在被租借!此记录无法被添加");
        if(rentRecord.getDateReturned()==null){
            copy.setStatus('0');
            copyRepository.save(copy);
        }
        rentRecordRepository.save(rentRecord);
    }

    public void deleteRentRecord(int id){
        AssertUtils.notNull(id, "id不能为空");
        RentRecord rentRecord = rentRecordRepository.findRentRecordByRentId(id);
        if(rentRecord.getDateReturned()==null){
            Copy copy = copyRepository.findCopyByCopyPkVideoIdAndCopyPkCopyId(rentRecord.getVideoId(),rentRecord.getCopyId());
            copy.setStatus('1');
            copyRepository.save(copy);
        }
        rentRecordRepository.delete(rentRecord);
    }

    public void updateRentRecord(RentRecord rentRecord){
        RentRecord oldRentRecord = rentRecordRepository.findRentRecordByRentId(rentRecord.getRentId());
        AssertUtils.notNull(oldRentRecord, "该租借记录对应的租入记录不存在！");
        rentRecordRepository.save(rentRecord);
    }
}
