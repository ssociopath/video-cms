package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.RentRecord;
import org.video.cms.data.entity.Video;
import org.video.cms.data.service.RentRecordService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/13
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rent")
public class RentRecordController {
    @Resource
    private RentRecordService rentRecordService;

    @GetMapping("/findAll")
    public ApplicationResponse<List<RentRecord>> getAll() {
        return ApplicationResponse.succeed("成功",  rentRecordService.getRentRecords());
    }

    @PostMapping("/add")
    public ApplicationResponse<Void> add(RentRecord rent) {
        rentRecordService.addRentRecord(rent);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/delete")
    public ApplicationResponse<Void> delete(int id) {
        rentRecordService.deleteRentRecord(id);
        return ApplicationResponse.succeed("成功");
    }
}
