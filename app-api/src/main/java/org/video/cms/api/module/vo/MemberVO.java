package org.video.cms.api.module.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.video.cms.data.entity.Member;


/**
 * @author bobo
 * @date 2020/12/6
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String memberName;
    private String memberId;
    private String dateRegister;

    public static MemberVO fromMember(Member member) {

        return MemberVO.builder()
                .memberName(member.getMemberName())
                .memberId(member.getMemberId())
                .dateRegister(member.getDateRegister())
                .build();
    }
}
