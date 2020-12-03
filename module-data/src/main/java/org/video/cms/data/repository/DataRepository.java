package org.video.cms.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bobo
 * @date 2020/12/3
 */

public interface DataRepository<Entity, Id> extends JpaRepository<Entity, Id> {
}
