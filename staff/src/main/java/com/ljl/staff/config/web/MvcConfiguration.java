package com.ljl.staff.config.web;

import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr_OO
 * @Date: 2020/9/23 12:09
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    /**
     * Spring容器
     */
    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 定义默认的请求处理器
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 跨域的过滤机制
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        return new FilterRegistrationBean(new Filter() {
            @Override
            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                    throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) req;
                HttpServletResponse response = (HttpServletResponse) res;
                String method = request.getMethod();
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "Accept, Origin, " +
                        "X-Requested-With, Content-Type,Last-Modified,device,token,staffToken");
                if ("OPTIONS".equals(method)) {//检测是options方法则直接返回200
                    response.setStatus(HttpStatus.OK.value());
                } else {
                    chain.doFilter(req, res);
                }
            }

            @Override
            public void init(FilterConfig filterConfig) {}

            @Override
            public void destroy() {}
        });
    }

    /**
     * 文件上传解析器
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        // 1024 * 1024 * 20 = 20M
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(20971520);
        return multipartResolver;
    }

    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        String basePath = "";
        String windows = "windows";
        //加载图片的默认地址前缀

        if(os.toLowerCase().startsWith(windows)) {
            registry.addResourceHandler("/goods/**")
                    .addResourceLocations("file:C:/scms/image/goods/");
        } else {
            registry.addResourceHandler("/goods/**")
                    .addResourceLocations("file:/scms/image/goods/");
        }

        if(!registry.hasMappingForPattern("/static/watermark.png")){
            registry.addResourceHandler("/static/watermark.png").addResourceLocations("classpath:/");
        }

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
    
    
}

