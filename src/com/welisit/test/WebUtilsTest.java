package com.welisit.test;

import com.welisit.bean.User;
import com.welisit.utils.WebUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WebUtilsTest {
    @Test
    public void testCopyParamsToBean(){
        User user = new User();
        Map map = new HashMap();
        map.put("username", "张三");
        map.put("password", "1231");
        map.put("email", "asda@qq.com");
        map.put("foo", "bar");

        WebUtils.copyParamsToBean(map, user);
        System.out.println(user);
    }


}
