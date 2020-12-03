package org.video.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/3
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String userId;
    private String pwd;
    private String username;
    private Date dateRegister;
}
