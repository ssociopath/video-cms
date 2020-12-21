package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.api.module.dto.MemberRentDTO;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Bill;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.service.BillRecordService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bobo
 * @date 2020/12/15
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bill")
public class BillRecordController {
    @Resource
    private BillRecordService billRecordService;

    @GetMapping("/findAll")
    public ApplicationResponse<List<BillRecord>> getAll() {
        return ApplicationResponse.succeed("成功",  billRecordService.getBillRecord());
    }

    @PostMapping("/getBill")
    public ApplicationResponse<Bill> getBill(int id) {
        return ApplicationResponse.succeed("成功",  billRecordService.getBillByRentId(id));
    }

    @PostMapping("/getBillRecord")
    public ApplicationResponse<BillRecord> getBillRecord(int id) {
        return ApplicationResponse.succeed("成功",  billRecordService.getBillRecordByRentId(id));
    }

    @PostMapping("/findByMember")
    public ApplicationResponse<List<BillRecord>> getByMemberId(String memberId) {
        return ApplicationResponse.succeed("成功",  billRecordService.getBillRecordsByMemberId(memberId));
    }

}
