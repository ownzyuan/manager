package com.manager.config.shiroAdmin;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.manager.utils.ShiroConfigUtil;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AdminShiroConfig {

    @Bean(name = "adminRealm")
    public AdminRealm adminRealm() {
        return new AdminRealm();
    }

    @Bean(name = "adminManager")
    public DefaultWebSecurityManager getAdminManager(@Qualifier("adminRealm") AdminRealm adminRealm) {
        DefaultWebSecurityManager adminManager = new DefaultWebSecurityManager();

        //关联EmployeeRealm
        adminManager.setRealm(adminRealm);
        return adminManager;
    }

    @Bean(name = "adminShiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryAdmin(@Qualifier("adminManager") DefaultWebSecurityManager adminManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(adminManager);

        /**
         * anon：无需认证就可以访问
         * authc：必须认证了才能访问
         * user：必须用有了 记住我 功能才能用
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        //添加拦截
        Map<String ,String > map = new LinkedHashMap<>();

        //不过滤
        map.put("/img/**","anon");
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/lib/**","anon");
        map.put("/fonts/**","anon");
        map.put("/icons/** ","anon");
        map.put("/page/home/**","anon");
        map.put("/page/login/**","anon");
        map.put("/page/register/**","anon");
        map.put("/page/404/**","anon");
        map.put("/loginController/login","anon");

        //管理页面
        map.put("/managerAdmin","perms[admin:login]");
        map.put("/managerAdmin/*","perms[admin:login]");
        //前往文件管理页面，以及上传文件
        map.put("/fileUpload","perms[admin:login]");
        map.put("/fileUpload/*","perms[admin:login]");
        //登出
        map.put("/signOut","perms[admin:login]");
        //删除员工
        map.put("/deleteAdmin","perms[admin:login]");
        map.put("/deleteAdmin/*","perms[admin:login]");
        //前往增加员工页面,以及添加员工
        map.put("/insertAdmin","perms[admin:login]");
        map.put("/insertAdmin/*","perms[admin:login]");
        //前往修改页面，以及修改员工
        map.put("/updateAdmin","perms[admin:login]");
        map.put("/updateAdmin/*","perms[admin:login]");

        bean.setFilterChainDefinitionMap(map);

        /*设置未授权页面
        bean.setUnauthorizedUrl("/noauth");*/

        //未登录就直接跳在登录页面
        bean.setLoginUrl("/");

        return bean;
    }

    public ShiroDialect getShiroDialect(){
        return ShiroConfigUtil.getShiroDialect();
    }

}
