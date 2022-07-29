package com.fubukianime.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MyCommandRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);


    @Override
    public void run(String... args) throws Exception {
        if(true){
            String cmd = "cmd /c start http://localhost:8080/pages/login.html";
            Runtime run = Runtime.getRuntime();
            try{
                run.exec(cmd);
                logger.debug("启动浏览器打开项目成功");
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }
    }
}
