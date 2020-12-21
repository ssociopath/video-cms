package org.video.cms.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/20
 */
@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Bill {
    @Id
    private int rentId;
    private int rent;
    private int penalty;
    private Date dateRent;
    private Date dateReturn;
    private Date dateReturned;
    private int amtPay;
}
