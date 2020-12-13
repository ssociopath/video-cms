package org.video.cms.data.entity.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author bobo
 * @date 2020/12/8
 */

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopyPk implements Serializable {
    private String videoId;
    private int copyId;
}
