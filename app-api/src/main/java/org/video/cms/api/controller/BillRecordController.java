package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.BillRecord;
import org.video.cms.data.service.BillRecordService;

import javax.annotation.Resource;
import java.util.List;

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
}
