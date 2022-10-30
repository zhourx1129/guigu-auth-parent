package com.zhourx.system.controller;

import com.zhourx.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    // login
    @PostMapping("/login")
    public Result login(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin-token zhourx");
        return Result.ok(map);
    }

    // info
    @GetMapping("/info")
    public Result info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin zhourx");
        return Result.ok(map);
    }

}
