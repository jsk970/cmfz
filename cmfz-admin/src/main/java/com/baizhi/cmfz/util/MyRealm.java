package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-11 19:21
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Admin admin = adminService.queryAdminByName(username);
        System.out.println("admin:"+admin);

        return new SimpleAuthenticationInfo(admin.getName(),admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()),UUID.randomUUID().toString());

    }
}
