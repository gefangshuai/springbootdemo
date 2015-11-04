package com.example.gefangshuai.user;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/4.
 */
/**
 * Cacheable注解负责将方法的返回值加入到缓存中
 * CacheEvict注解负责清除缓存(它的三个参数与@Cacheable的意思是一样的)
 * @see ----------------------------------------------------------------------------------------------------------
 * @see value------缓存位置的名称,不能为空,若使用EHCache则其值为ehcache.xml中的<cache name="myCache"/>
 * @see key--------缓存的Key,默认为空(表示使用方法的参数类型及参数值作为key),支持SpEL
 * @see condition--只有满足条件的情况才会加入缓存,默认为空(表示全部都加入缓存),支持SpEL
 * @see ----------------------------------------------------------------------------------------------------------
 * @see 该注解的源码位于spring-context-3.2.4.RELEASE-sources.jar中
 * @see Spring针对Ehcache支持的Java源码位于spring-context-support-3.2.4.RELEASE-sources.jar中
 * @see ----------------------------------------------------------------------------------------------------------
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    @Cacheable(value="users")
    public List<User> getCacheUsers() {
        return userDao.findAll();
    }

    @CacheEvict(value = "users")
    public List<User> getNoCacheUsers(){
        return userDao.findAll();
    }

}
