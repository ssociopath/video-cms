package org.video.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author bobo
 * @date 2020/12/8
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    private String videoId;
    private String videoName;
    private int stock;
    private int rent;
    private int penalty;
}
