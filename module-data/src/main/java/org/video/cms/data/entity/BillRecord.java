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
 * @date 2020/12/15
 */
@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class BillRecord {
    @Id
    private int rentId;
    private String memberId;
    private int amtPay;
    private int amtPaid;
    private Date datePay;
    private Date datePaid;
}
