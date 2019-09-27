package com.bonc.bcos.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * @desc:应用数据初始化
 * @author:
 * @time:
 */

@Component
public class AppInit implements CommandLineRunner{

    private final BootConfig config;

    @Autowired
    public AppInit(BootConfig config) {
        this.config = config;
    }

    @Override
    public void run(String... args){
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");

        // 缓存全局参数

        // 释放任务资源

        // 初始化任务标签信息

        // 主机设备归属设备源数据处理，兼容历史版本

        System.out.println(">>>>>>>>>>>>>>>服务启动执行，数据初始化完成<<<<<<<<<<<<<");
    }

}
