package com.welisit.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 0:37
 */
public class Order {

    private String orderId;
    private Date createTime;
    private BigDecimal price;
    /**
     * 0 未发货，
     * 1 已发货，
     * 2 表示已签收
     */
    private Integer status = 0;
    private Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.userId = userId;
    }
}
