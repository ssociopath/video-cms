package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.utils.DateUtil;
import org.video.cms.data.entity.Bill;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.entity.RentRecord;
import org.video.cms.data.entity.Video;
import org.video.cms.data.repository.concrete.BillRecordRepository;
import org.video.cms.data.repository.concrete.BillRepository;
import org.video.cms.data.repository.concrete.VideoRepository;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @Resource
    BillRepository billRepository;
    @Resource
    VideoRepository videoRepository;

    public List<BillRecord> getBillRecord(){
        return billRecordRepository.findAll();
    }

    public List<BillRecord> getBillRecordsByMemberId(String memberId){
        return billRecordRepository.findAllByMemberId(memberId);
    }

    public Bill getBillByRentId(int id){
        return billRepository.findById(id);
    }

    public BillRecord getBillRecordByRentId(int id){
        return billRecordRepository.findBillRecordByRentId(id);
    }

    public void addBillRecord(RentRecord rentRecord){
        Video video = videoRepository.findVideoByVideoId(rentRecord.getVideoId());
        int rent = video.getRent();
        int penalty = video.getPenalty();
        int sum=0;
        LocalDate rentDate = rentRecord.getDateRent().toLocalDate();
        LocalDate returnDate = rentRecord.getDateReturn().toLocalDate();
        LocalDate returnedDate = rentRecord.getDateReturned().toLocalDate();
        if(returnedDate.isAfter(returnDate)){
            sum += rent * ChronoUnit.DAYS.between(rentDate,returnDate);
            sum += penalty * ChronoUnit.DAYS.between(returnDate,returnedDate);
        }else{
            sum += rent * ChronoUnit.DAYS.between(rentDate,returnedDate);
        }
        billRecordRepository.save(BillRecord.builder()
                .rentId(rentRecord.getRentId())
                .memberId(rentRecord.getMemberId())
                .amtPay(sum)
                .datePay(rentRecord.getDateReturned())
                .build());
    }

    public void updateBillRecord(BillRecord billRecord){
        BillRecord oldBillRecord = billRecordRepository.findBillRecordByRentId(billRecord.getRentId());
        AssertUtils.notNull(oldBillRecord, "该账单记录不存在！");
        billRecordRepository.save(billRecord);
    }
}
