package org.video.cms.data.service.concrete;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.video.cms.data.entity.Member;
import org.video.cms.data.service.BaseDataService;

import java.util.List;

/**
 * @author bobo
 * @date 2020/12/3
 */
@Service
@Slf4j
public class MemberService extends BaseDataService<Member,String> {
    public List<Member> getMembers(){
        return this.findAll();
    }
}
