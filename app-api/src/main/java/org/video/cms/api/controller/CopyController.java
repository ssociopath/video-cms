package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.api.module.vo.CopyVO;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Copy;
import org.video.cms.data.entity.id.CopyPk;
import org.video.cms.data.service.CopyService;
import org.video.cms.data.service.VideoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bobo
 * @date 2020/12/8
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/copy")
public class CopyController {
    @Resource
    private CopyService copyService;

    @GetMapping("/findAll")
    public ApplicationResponse<List<CopyVO>> getAll() {
        List<CopyVO> copyVOList = copyService.getCopies().stream().map(CopyVO::fromCopy).collect(Collectors.toList());
        return ApplicationResponse.succeed("成功", copyVOList);
    }

    @PostMapping("/delete")
    public ApplicationResponse<Void> delete(CopyPk id) {
        copyService.deleteCopy(id);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/add")
    public ApplicationResponse<Void> add(CopyVO copyVO) {
        copyService.addCopy(copyVO.toCopy());
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/update")
    public ApplicationResponse<Void> update(String id, CopyVO copyVO) {
        copyService.updateCopy(Integer.parseInt(id), copyVO.toCopy());
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/ids")
    public ApplicationResponse<List<String>> getCopyId(String id) {
        return ApplicationResponse.succeed("成功",
                copyService.getCopies().stream()
                        .filter(x->x.getCopyPk().getVideoId().equals(id))
                        .map(x->String.valueOf(x.getCopyPk().getCopyId()))
                        .collect(Collectors.toList()));
    }

}
