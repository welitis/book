package com.welisit.bean;

import java.util.List;

/**
 * @author welisit
 * @Description 分页
 * @create 2020-03-21 23:31
 */
public class Page<T> {
    /**
     *     每页记录数量
     */
    public static final Integer PAGE_SIZE = 4;

    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     *  总页码
     */
    private Integer pageTotal;
    /**
     *  总记录数
     */
    private Integer pageTotalCount;
    /**
     *  每页数据集合
     */
    private List<T> items;

    /**
     * 当前分页对象请求的servlet地址段
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url=" + url +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        if (pageNo < 1) {
            this.pageNo = 1;
        }
        if (pageNo > pageTotal) {
            this.pageNo = pageTotal;
        }
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }
}
