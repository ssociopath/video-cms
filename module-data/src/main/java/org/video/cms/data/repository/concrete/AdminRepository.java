package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.Admin;
import org.video.cms.data.repository.DataRepository;

import java.util.Optional;

/**
 * @author bobo
 * @date 2020/12/4
 */

public interface AdminRepository extends DataRepository<Admin,String> {
    Admin findByAdminIdAndAdminPwd(String adminId, String adminPwd);
}
