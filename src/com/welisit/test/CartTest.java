package com.welisit.test;

import com.welisit.bean.Cart;
import com.welisit.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-26 20:43
 */
public class CartTest {

    private Cart cart = new Cart();

    @Test
    public void addItem() {
        CartItem item = new CartItem(1, "学习之王", 2, new BigDecimal(23));
        CartItem item2 = new CartItem(3, "学习王", 1, new BigDecimal(99));
        cart.addItem(item);
        cart.addItem(item);
        cart.addItem(item2);
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getTotalCount());
        System.out.println(cart.getItems());
    }

    @Test
    public void addItems() {
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem(1, "学习之王", 2, new BigDecimal(23)));
        list.add(new CartItem(3, "学习王", 1, new BigDecimal(99)));
        cart.addItems(list);
        System.out.println(cart);
    }

    @Test
    public void deleteItemById() {
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem(1, "学习之王", 2, new BigDecimal(23)));
        list.add(new CartItem(3, "学习王", 1, new BigDecimal(99)));
        cart.addItems(list);
        cart.deleteItemById(3);
        System.out.println(cart);
    }

    @Test
    public void updateItemCount() {
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem(1, "学习之王", 2, new BigDecimal(23)));
        list.add(new CartItem(3, "学习王", 1, new BigDecimal(99)));
        cart.addItems(list);
        cart.updateItemCount(1, 5);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem(1, "学习之王", 2, new BigDecimal(23)));
        list.add(new CartItem(3, "学习王", 1, new BigDecimal(99)));
        cart.addItems(list);
        cart.clear();
        System.out.println(cart);
    }
}