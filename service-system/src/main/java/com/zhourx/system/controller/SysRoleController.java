package com.zhourx.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhourx.common.result.Result;
import com.zhourx.model.system.SysRole;
import com.zhourx.model.vo.SysRoleQueryVo;
import com.zhourx.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    // 批量删除
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids){
        boolean isSuccess = sysRoleService.removeByIds(ids);
        return isSuccess ? Result.ok() : Result.fail();
    }


    /**
     * 通过id查询角色
     * @param id id
     * @return {@link Result}
     */
    @GetMapping("/{id}")
    public Result findRoleById(@PathVariable Long id){
        SysRole roleServiceById = sysRoleService.getById(id);
        return Result.ok(roleServiceById);
    }


    /**
     * 添加角色
     * @param sysRole 系统作用
     * @return {@link Result}
     */
    @PostMapping
    public Result saveRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        }else {
            return  Result.fail();
        }
    }

    /**
     * 分页查询
     * @param page           页面
     * @param limit          限制
     * @param sysRoleQueryVo 系统角色查询签证官
     * @return {@link Result}
     */
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page, @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo){
        Page<SysRole> pageParam = new Page<>();
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        return Result.ok(pageModel);
    }
    /**
     * 更新作用
     *
     * @param sysRole 系统作用
     */
    @PutMapping
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean update = sysRoleService.updateById(sysRole);
        if (update){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    /**
     * 删除角色
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result removeRole(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        }else {
            return Result.fail();
        }

    }

    /**
     * 查找所有纪录的接口
     * @return {@link List}<{@link SysRole}>
     */
    @GetMapping
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }
}
