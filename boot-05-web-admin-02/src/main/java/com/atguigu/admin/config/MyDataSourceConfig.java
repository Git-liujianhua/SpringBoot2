package com.atguigu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated
//@Configuration
public class MyDataSourceConfig {

    /**
     * 配置数据源使用druid的数据源
     * @return
     */
    //默认的自动配置是判断容器中没有自定义的DataSource才会配置@ConditionalOnMissingBean({DataSource.class})
//    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
        /**
         *  stat是监控统计功能，SQL防火墙功能
         */
//        druidDataSource.setFilters("stat,wall");
//        druidDataSource.setMaxActive(10);
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     * 内置监控页面是一个Servlet，具体配置看这里： https://github.com/alibaba/druid/wiki/配置_StatViewServlet配置
     * Session监控需要让JavaBean继承序列化implements Serializable
     * @return
     */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","1234");
        return servletRegistrationBean;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     * Web关联监控配置
     * https://github.com/alibaba/druid/wiki/配置_配置WebStatFilter
     * @return
     */
//    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * Spring监控配置
     * Spring关联监控配置
     * https://github.com/alibaba/druid/wiki/配置_Druid和Spring关联监控配置
     * 下边3个配置
     * @return
     */
//    @Bean
    public DruidStatInterceptor druidStatInterceptor(){
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return druidStatInterceptor;
    }

    /**
     * 扫描路径
     * @return
     */
//    @Bean
//    @Scope("prototype")
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(){
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPatterns("com.atguigu.admin.servlet.*");
        return jdkRegexpMethodPointcut;
    }

//    @Autowired
//    JdkRegexpMethodPointcut jdkRegexpMethodPointcut;
//
//    @Autowired
//    DruidStatInterceptor druidStatInterceptor;

    /**
     * aop切入
     * @param jdkRegexpMethodPointcut
     * @param druidStatInterceptor
     * @return
     */
//    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(JdkRegexpMethodPointcut jdkRegexpMethodPointcut,DruidStatInterceptor druidStatInterceptor){
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(jdkRegexpMethodPointcut);
        defaultPointcutAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointcutAdvisor;
    }

}
