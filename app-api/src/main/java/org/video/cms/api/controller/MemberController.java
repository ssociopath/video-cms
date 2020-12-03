package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Member;
import org.video.cms.data.service.concrete.MemberService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/3
 */

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping
    public ApplicationResponse<List<Member>> getAll() {
        return ApplicationResponse.succeed("成功", memberService.getMembers());
    }
}
