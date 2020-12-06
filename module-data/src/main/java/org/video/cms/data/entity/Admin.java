package org.video.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/4
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin{
    @Id
    private String adminId;
    private String adminPwd;
    private String adminName;
}

