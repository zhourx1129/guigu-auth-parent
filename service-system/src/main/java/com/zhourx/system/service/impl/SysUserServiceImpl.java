package com.zhourx.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhourx.model.system.SysUser;
import com.zhourx.system.mapper.SysUserMapper;
import com.zhourx.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhourx
 * @since 2022-10-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
