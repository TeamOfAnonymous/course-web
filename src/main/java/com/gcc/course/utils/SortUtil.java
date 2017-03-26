package com.gcc.course.utils;

import org.springframework.data.domain.Sort;

/**
 * Created by WangZK on 2017/3/13.
 * 排序工具类
 */
public class SortUtil {

    /**
     * 获取基础的排序对象
     *
     * @param sortType  排序方法
     * @param sortField 排序字段
     * @return
     */
    public static Sort basicSort(String sortType, String sortField) {
        Sort sort = new Sort(Sort.Direction.fromString(sortType), sortField);
        return sort;
    }

    /**
     * 降序排序
     *
     * @return
     */
    public static Sort SortForDesc(String sortField) {
        return basicSort("DESC", sortField);
    }

    /**
     * 升序排序
     *
     * @param sortField
     * @return
     */
    public static Sort SortForAsc(String sortField) {
        return basicSort("Asc", sortField);
    }


    /**
     * 添加时间降序排序
     *
     * @return
     */
    public static Sort addTimeSortForDesc() {
        return SortForDesc("addTime");
    }


    /**
     * 删除时间降序排序
     *
     * @return
     */
    public static Sort deletedTimeSortForDesc() {
        return SortForDesc("deletedTime");
    }

    /**
     * 发表时间降序排序
     *
     * @return
     */
    public static Sort publishedTimeSortForDesc() {
        return SortForDesc("publishedTime");
    }

}
