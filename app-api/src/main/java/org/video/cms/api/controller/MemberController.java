package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.api.module.vo.MemberVO;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Member;
import org.video.cms.data.service.MemberService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bobo
 * @date 2020/12/3
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/findAll")
    public ApplicationResponse<List<MemberVO>> getAll() {
        List<MemberVO> memberVOList = memberService.getMembers().stream().map(MemberVO::fromBanner).collect(Collectors.toList());
        return ApplicationResponse.succeed("成功", memberVOList);
    }

    @PostMapping("/delete")
    public ApplicationResponse<Void> delete(String id) {
        memberService.deleteMember(id);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/add")
    public ApplicationResponse<Void> add(Member member) {
        memberService.addMember(member);
        return ApplicationResponse.succeed("成功");
    }

    @PostMapping("/update")
    public ApplicationResponse<Void> update(Member member) {
        memberService.updateMember(member);
        return ApplicationResponse.succeed("成功");
    }
}
