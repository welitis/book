package com.welisit.utils;

import com.welisit.bean.Page;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamsToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 当解析报错时，返回默认值
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 生成展示的页码范围
     * @param page
     * @param size 左右个数范围大小
     * @return
     */
    public static List<Integer> getPageScopeList(Page page, int size) {
        int start = Math.max(1, page.getPageNo() - size);
        int end = Math.min(page.getPageNo() + size, page.getPageTotal());
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        return list;
    }
}
