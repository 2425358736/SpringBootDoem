## SpringBoot 搭建教程
### 1. SpringBoot简单搭建
#### 第一步： 新建maven项目
##### 引入spring boot开发依赖包
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>SpringBoot</groupId>
    <artifactId>SpringBoot</artifactId>
    <version>1.0-SNAPSHOT</version>
    
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
        <relativePath/>
    </parent>
    <dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    </dependencies>

</project>
```
##### 新建spring boot启动类 SpringBootAppliction.java
```
package com.liuzhiqiang;

/**
 * Created by SCKJ on 2018/1/2.
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhiqiang on 2017/9/7.
 */
@SpringBootApplication
@Controller
@EnableWebMvc
public class SpringBootAppliction extends WebMvcConfigurerAdapter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppliction.class, args);
    }

    @RequestMapping("/test")
    @ResponseBody
    Map<String,Object> test() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("作者","刘志强");
        map.put("时间",new Date());
        return map;
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务器已起动");
    }
}

```
==注意：     SpringBootAppliction类不能直接放在Java目录下==
##### idea 配置启动项
![image](D:/我的文档/我的文档/Tencent%20Files/2425358736/FileRecv/MobileFile/Image/]%7B9GT8P~O%7B$$2_E~73_ZLF4.png)
