package com.fubukianime.config;

import com.fubukianime.controller.utils.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Slf4j
@Configuration
@ComponentScan("com.fubukianime.controller")
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 设置静态资源映射
     * @param registry
     */
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射...");
        registry.addResourceHandler("/api/**").addResourceLocations("classpath:/api/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/pages/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/plugins/");
        registry.addResourceHandler("/styles/**").addResourceLocations("classpath:/styles/");
        registry.addResourceHandler("/vedio/**").addResourceLocations("classpath:/vedio/");
        registry.addResourceHandler("/vedio/**").addResourceLocations("classpath:/vedio/");
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:/index.html");
        registry.addResourceHandler("/minlogo.ico").addResourceLocations("classpath:/minlogo.ico");
        //registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }*/

    /**
     * 扩展mvc框架的消息转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置对象转换器，底层使用Jackson将Java对象转为json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将上面的消息转换器对象追加到mvc框架的转换器集合中
        converters.add(0,messageConverter);
    }
}
