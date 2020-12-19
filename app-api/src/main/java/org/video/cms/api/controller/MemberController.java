package org.video.cms.api.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.video.cms.api.module.vo.MemberVO;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.entity.Member;
import org.video.cms.data.service.MemberService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
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
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(value = "/getLoginInfo")
    public ApplicationResponse<MemberVO> getLoginInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Object memberVO = redisTemplate.opsForValue().get(token);
        AssertUtils.isTrue(memberVO!=null, ApplicationException.withResponse(SystemCodeEnum.NEED_LOGIN, "获取登录用户失败"));
        return ApplicationResponse.succeed("成功", (MemberVO) memberVO);
    }

    @PostMapping(value = "/login")
    public ApplicationResponse<String> login(String id, String pwd) {
        String token = UUID.randomUUID()+"";
        Member member = memberService.getMemberByIdAndPwd(id, pwd);
        redisTemplate.opsForValue().set(token, MemberVO.fromMember(member), Duration.ofMinutes(300L));
        return ApplicationResponse.succeed("成功", token);
    }

    @GetMapping("/findAll")
    public ApplicationResponse<List<MemberVO>> getAll() {
        List<MemberVO> memberVOList = memberService.getMembers().stream().map(MemberVO::fromMember).collect(Collectors.toList());
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
    public ApplicationResponse<Void> update(String id, Member member) {
        memberService.updateMember(id, member);
        return ApplicationResponse.succeed("成功");
    }

    @GetMapping("/ids")
    public ApplicationResponse<List<String>> getMemberId() {
        return ApplicationResponse.succeed("成功",memberService.getMembers().stream().map(Member::getMemberId).collect(Collectors.toList()));
    }
}
