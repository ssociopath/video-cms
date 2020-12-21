package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.RentRecord;
import org.video.cms.data.entity.Video;
import org.video.cms.data.entity.id.CopyPk;
import org.video.cms.data.repository.concrete.CopyRepository;
import org.video.cms.data.service.BillRecordService;
import org.video.cms.data.service.CopyService;
import org.video.cms.data.service.RentRecordService;
import org.video.cms.data.service.VideoService;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author bobo
 * @date 2020/12/21
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/center")
public class CenterController {
    @Resource
    private RentRecordService rentRecordService;
    @Resource
    private CopyService copyService;
    @Resource
    private BillRecordService billRecordService;

    @PostMapping("/rent")
    public ApplicationResponse<Void> addRentRecord(RentRecord rent) {
        rentRecordService.addRentRecord(rent);
        copyService.updateCopyStatus(Copy.builder()
                .copyPk(new CopyPk(rent.getVideoId(),rent.getCopyId()))
                .status('0')
                .build());
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/return")
    public ApplicationResponse<Void> addReturnRecord(RentRecord rent){
        rentRecordService.updateRentRecord(rent);
        copyService.updateCopyStatus(Copy.builder()
                .copyPk(new CopyPk(rent.getVideoId(),rent.getCopyId()))
                .status('1')
                .build());
        billRecordService.addBillRecord(rent);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/pay")
    public ApplicationResponse<Void> addPaidRecord(BillRecord bill){
        billRecordService.updateBillRecord(bill);
        return ApplicationResponse.succeed("成功");
    }
}
