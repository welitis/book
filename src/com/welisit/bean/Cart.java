package com.welisit.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author welisit
 * @Description 购物车数据模型
 * @create 2020-03-26 20:16
 */
public class Cart {

    /**
     * 购物车商品项Map
     * key: 商品编号
     * value: 商品项对象
     * LinkedHashMap能够记录加入数据的顺序
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * 获取商品的总数
     *
     * @return
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }


    /**
     * 获取商品总价
     *
     * @return
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Cart(Map<Integer, CartItem> items) {

        this.items = items;
    }

    public Cart() {
    }

    /**
     * 添加商品
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 查看购物车是否存在该商品，存在则+1，否则创建
        CartItem item = items.get(cartItem.getId());
        if (item != null) {
            // 如果不为null，说明已存在该商品
            item.setCount(item.getCount() + 1);
        } else {
            // 否则将该商品项保存进map中
            items.put(cartItem.getId(), cartItem);
        }
    }

    /**
     * 添加多个商品
     *
     * @param cartItems
     */
    public void addItems(List<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            addItem(item);
        }
    }

    /**
     * 删除某件商品
     *
     * @param id
     */
    public void deleteItemById(Integer id) {
        items.remove(id);
    }

    /**
     * 更新某个商品项的数量
     *
     * @param count
     */
    public void updateItemCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
        }
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }
}
