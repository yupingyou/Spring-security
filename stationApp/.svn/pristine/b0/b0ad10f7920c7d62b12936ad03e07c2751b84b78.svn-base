package com.xingguo.entity.common;

import java.io.Serializable;
import java.util.List;

import com.xingguo.constants.SystemConst;

public class PaginationSupport<T> implements Serializable {

    public final static int PAGE_SIZE = SystemConst.PAGE_SIZE;
    private int pageSize = PAGE_SIZE;
    private List<T> items;
    private int totalCount;
    private int startIndex = 0;

    public PaginationSupport() {
        super();
        setPageSize(PAGE_SIZE);
        setStartIndex(0);
    }

    public PaginationSupport(List<T> items, int totalCount) {
        super();
        setPageSize(PAGE_SIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(0);
    }

    public PaginationSupport(List<T> items, int totalCount, int startIndex) {
        super();
        setPageSize(PAGE_SIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);
    }

    public PaginationSupport(List<T> items, int totalCount, int pageSize,
                             int startIndex) {
        super();
        setPageSize(pageSize);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);
    }

    public boolean isEmpty() {
        return (getTotalCount() <= 0);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageCount() {
        if (getPageSize() == 0 || getTotalCount() == 0) {
            return 0;
        }
        int count = getTotalCount() / getPageSize();
        if (getTotalCount() % getPageSize() != 0) {
            count++;
        }
        return count;
    }

    public int getPageNo() {
        if (getPageSize() == 0 || getTotalCount() == 0) {
            return 0;
        }
        return (getStartIndex() / getPageSize()) + 1;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
        } else {
            this.totalCount = 0;
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getNextIndex() {
        int nextIndex = getStartIndex() + pageSize;
        if (nextIndex >= totalCount) {
            return getStartIndex();
        } else {
            return nextIndex;
        }
    }

    public int getPreviousIndex() {
        int previousIndex = getStartIndex() - pageSize;
        if (previousIndex < 0) {
            return 0;
        } else {
            return previousIndex;
        }
    }
}
