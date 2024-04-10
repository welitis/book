package com.welisit.bean;

import java.math.BigDecimal;

/**
 * @author welisit
 * @Description 购物车商品项
 * @create 2020-03-26 20:18
 */
public class CartItem {
    /**
     * 商品编号
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品单价
     */
    private BigDecimal price;


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + this.getTotalPrice() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(count));
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public CartItem() {
    }
}
