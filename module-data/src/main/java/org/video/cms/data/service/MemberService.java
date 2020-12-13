package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.entity.Member;
import org.video.cms.data.repository.concrete.MemberRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo
 * @date 2020/12/3copy.getCopyPk()
 */
@Service
@Slf4j
public class MemberService{
    @Resource
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public void deleteMember(String id){
        AssertUtils.notNull(id, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_MISSING, "id不能为空"));
        memberRepository.deleteById(id);
    }

    public void addMember(Member member){
        Member oldMember = memberRepository.findByMemberId(member.getMemberId());
        AssertUtils.isNull(oldMember, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该手机号已注册！"));
        memberRepository.save(member);
    }

    public void updateMember(String id, Member member){
        Member oldMember = memberRepository.findByMemberId(id);
        AssertUtils.notNull(oldMember, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该手机号注册的会员不存在！"));
        AssertUtils.isNull(memberRepository.findByMemberId(member.getMemberId()), ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "该手机号已注册！"));
        memberRepository.delete(oldMember);
        memberRepository.save(member);
    }
}
