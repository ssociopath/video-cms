package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.repository.DataRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author bobo
 * @date 2020/12/3
 */
@Slf4j
public abstract class BaseDataService<Entity, Id> {
    @Autowired
    protected DataRepository<Entity, Id> entityRepository;

    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    public Entity getOne(Id id) {
        AssertUtils.notNull(id, ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, "ID不能为空"));
        return entityRepository.findById(id).orElse(null);
    }
}
