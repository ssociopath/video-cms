package org.video.cms.data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.video.cms.common.exception.ApplicationException;
import org.video.cms.common.exception.AssertUtils;
import org.video.cms.common.response.SystemCodeEnum;
import org.video.cms.data.entity.Admin;
import org.video.cms.data.repository.concrete.AdminRepository;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;


/**
 * @author bobo
 * @date 2020/12/4
 */
@Service
@Slf4j
public class AdminService{
    @Resource
    private AdminRepository adminRepository;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Admin getAdminByToken(String token){
        Object admin = redisTemplate.opsForValue().get(token);
        AssertUtils.isTrue(admin!=null, ApplicationException.withResponse(SystemCodeEnum.NEED_LOGIN, "获取登录用户失败"));
        return (Admin) admin;
    }

    public String getAdminByLogin(String adminId,String adminPwd){
        Admin admin = adminRepository.findByAdminIdAndAdminPwd(adminId,adminPwd);
        AssertUtils.isTrue(admin!=null, ApplicationException.withResponse(SystemCodeEnum.NEED_LOGIN, "用户名或密码错误"));
        String token = UUID.randomUUID()+"";
        redisTemplate.opsForValue().set(token, admin, Duration.ofMinutes(30L));
        return token;
    }
}
