package org.video.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/13
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentRecord {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int rentId;
    private String videoId;
    private int copyId;
    private String memberId;
    private Date dateRent;
    private Date dateReturn;
    private Date dateReturned;


}
