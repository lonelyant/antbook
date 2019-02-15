package com.ant.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/15 09:42
 * @Description:
 */
public class PullRefreshEntity<T> implements Serializable{
    private List<T> dataList;
    private boolean hasMore;

    public List<T> getDataList() {
        if (dataList == null)dataList = new ArrayList<>();
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
