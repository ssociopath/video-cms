package org.video.cms.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.video.cms.data.entity.id.CopyPk;

import javax.persistence.EmbeddedId;
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
public class Copy {
    @EmbeddedId
    private CopyPk copyPk;
    private char status;


}
