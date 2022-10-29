package com.zhourx.system.test;


import com.zhourx.model.system.SysRole;
import com.zhourx.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;
    // 查询所有
    @Test
    public void findAll(){
        List<SysRole> list = sysRoleService.list();
        for (SysRole sysRole : list) {
            System.out.println(sysRole);
        }
    }
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleCode("test2");
        sysRole.setRoleName("test2");
        sysRole.setDescription("test2");
        sysRoleService.save(sysRole);
    }

    @Test
    public void update(){
        SysRole byId = sysRoleService.getById(1);
        byId.setDescription("系统管理员");
        sysRoleService.updateById(byId);
    }
    @Test
    public void removeById(){
        sysRoleService.removeById("1585134317321363457");
    }
}
