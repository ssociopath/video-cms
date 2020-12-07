package org.video.cms.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author bobo
 * @date 2020/12/3
 */

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member{
    @Id
    private String memberId;
    private String memberPwd;
    private String memberName;
    private Timestamp dateRegister;

    public Member(String memberId, String memberPwd, String memberName, String dateRegister) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        try {
            this.dateRegister = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateRegister).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDateRegister() {
        //方法一:优势在于可以灵活的设置字符串的形式。
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateRegister);
    }
}
