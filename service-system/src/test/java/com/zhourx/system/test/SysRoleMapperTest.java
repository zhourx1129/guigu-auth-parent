package com.zhourx.system.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhourx.model.system.SysRole;
import com.zhourx.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    // 7.条件删除
    @Test
    public void testDelete(){
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(SysRole::getRoleName,"管理员");
        sysRoleMapper.delete(queryWrapper);
    }
    // 6.条件查询
    @Test
    public void testSelect(){
        // QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        // queryWrapper.eq("role_name", "普通管理员");
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleName,"普通管理员");
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
    // 5.批量删除
    @Test
    public void deleteBatchDelete(){
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
    }
    // 4.id删除
    @Test
    public void deleteById(){
        sysRoleMapper.deleteById(2);
    }
    // 3.修改操作
    @Test
    public void update(){
        // 根据id查询
        SysRole sysRole = sysRoleMapper.selectById(1);
        // 设置修改值
        sysRole.setDescription("系统管理员zhourx");
        // 调佣方法实现修改
        sysRoleMapper.updateById(sysRole);
    }

    // 2.添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("test");
        sysRole.setRoleCode("testmanager");
        sysRole.setDescription("ceshi");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }
    // 1.查询表中所有纪录
    @Test
    public void findAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
}
