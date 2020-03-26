package com.welisit.test;

import com.welisit.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class BeanUtilsTest {
    @SuppressWarnings("AlibabaCollectionInitShouldAssignCapacity")
    @Test
    public void testPopulate() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        Map map = new HashMap();
        map.put("username", "张三");
        map.put("password", "1231");
        map.put("email", "asda@qq.com");
        map.put("foo", "bar");


        BeanUtils.populate(user, map);
        System.out.println(user);
    }

    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.copyProperty(user, "username", "zhangan");
        System.out.println(user);
    }


}
