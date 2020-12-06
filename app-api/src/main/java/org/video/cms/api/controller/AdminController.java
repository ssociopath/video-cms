package org.video.cms.api.controller;

import org.springframework.web.bind.annotation.*;
import org.video.cms.common.response.ApplicationResponse;
import org.video.cms.data.entity.Admin;
import org.video.cms.data.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author bobo
 * @date 2020/12/4
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping(value = "/getLoginInfo")
    public ApplicationResponse<Admin> getLoginInfo(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return ApplicationResponse.succeed("成功", adminService.getAdminByToken(token));
    }

    @PostMapping(value = "/login")
    public ApplicationResponse<String> login(String id, String pwd) {
        return ApplicationResponse.succeed("成功", adminService.getAdminByLogin(id,pwd));
    }
}
