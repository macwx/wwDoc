package com.macw.wwdoc;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
@MapperScan("com.macw.wwdoc.mapper")
public class WwdocApplication {
    public final static Logger log = LoggerFactory.getLogger(WwdocApplication.class);


    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WwdocApplication.class, args);
        Environment env = applicationContext.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        String url = "http://" + ip + ":" + port + path + "index";
        log.info(" __    ___   _      ___   _     ____ _____  ____ ");
        log.info("/ /`  / / \\ | |\\/| | |_) | |   | |_   | |  | |_  ");
        log.info("\\_\\_, \\_\\_/ |_|  | |_|   |_|__ |_|__  |_|  |_|__ ");
        log.info("                                                      ");
        log.info("wwDoc-在线接口文档启动完毕，地址：{}",url );
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "index\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "index\n" +
                "----------------------------------------------------------");

            String os = System.getProperty("os.name");
            // 默认为 windows时才自动打开页面
            if (StringUtils.containsIgnoreCase(os, "windows")) {
                //使用默认浏览器打开系统登录页
                try {
                    Runtime.getRuntime().exec("cmd  /c  start " + url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }



}
