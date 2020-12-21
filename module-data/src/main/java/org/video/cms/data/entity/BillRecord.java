package org.video.cms.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/15
 */
@Data
@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BillRecord {
    @Id
    private int rentId;
    private String memberId;
    private int amtPay;
    private int amtPaid;
    private Date datePay;
    private Date datePaid;

    public BillRecord(int rentId, String memberId, int amtPay, Date datePay) {
        this.rentId = rentId;
        this.memberId = memberId;
        this.amtPay = amtPay;
        this.datePay = datePay;
    }
}
