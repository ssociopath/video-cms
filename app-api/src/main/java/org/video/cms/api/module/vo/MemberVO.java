package org.video.cms.api.module.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.video.cms.data.entity.Member;

import java.sql.Timestamp;

/**
 * @author bobo
 * @date 2020/12/6
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String name;
    private String phone;
    private String dateRegister;

    public static MemberVO fromBanner(Member member) {

        return MemberVO.builder()
                .name(member.getMemberName())
                .phone(member.getMemberId())
                .dateRegister(member.getDateRegister())
                .build();
    }
}
