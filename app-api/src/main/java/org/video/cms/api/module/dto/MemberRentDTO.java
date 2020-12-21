package org.video.cms.api.module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.video.cms.data.entity.RentRecord;

import java.sql.Date;

/**
 * @author bobo
 * @date 2020/12/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRentDTO {
    private String rentId;
    private String videoId;
    private String copyId;
    private Date dateRent;
    private Date dateReturn;
    private Date dateReturned;

    public static MemberRentDTO fromRentRecord(RentRecord rentRecord) {

        return MemberRentDTO.builder()
                .rentId(String.valueOf(rentRecord.getRentId()))
                .videoId(rentRecord.getVideoId())
                .copyId(String.valueOf(rentRecord.getCopyId()))
                .dateRent(rentRecord.getDateRent())
                .dateReturn(rentRecord.getDateReturn())
                .dateReturned(rentRecord.getDateReturned())
                .build();
    }
}
