package com.yatong.exam.service.Impl;

import cn.dev33.satoken.stp.StpInterface;
import com.yatong.exam.mapper.StpMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    StpMapper stpMapper;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        int userId= Integer.parseInt(o.toString());
        List<Map<String, Object>> permissionNameAndKey = stpMapper.getPermission(userId);
        List<String> permissionKey = new ArrayList<>();

        for (Map<String, Object> map : permissionNameAndKey) {
            if (map.get("permission_key") instanceof String) {
                permissionKey.add((String) map.get("permission_key"));
            }
        }
        log.info("权限："+permissionKey.toString());
        return permissionKey;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        int userId= Integer.parseInt(o.toString());
        List<Map<String, Object>> roleNameAndKey = stpMapper.getRole(userId);
        List<String> roleKey = new ArrayList<>();
        for (Map<String, Object> map : roleNameAndKey) {
            if (map.get("role_key") instanceof String) {
                roleKey.add((String) map.get("role_key"));
            }
        }
        log.info("角色：" + roleKey.toString());
        return roleKey;
    }
}
