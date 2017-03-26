package com.gcc.course.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by WangZK on 2017/3/13.
 * 分页工具类
 */
public class PageUtil {


    /**
     * 获取基础分页对象
     *
     * @param page 获取第几页
     * @param size 每页条数
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size) {
        page = (page == null || page < 0) ? 0 : page;
        size = (size == null || size <= 0) ? 10 : size;
        Pageable pageable = new PageRequest(page, size);
        return pageable;
    }

    /**
     * 获取有排序功能的分页对象
     *
     * @param page
     * @param size
     * @param sort
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size, Sort sort) {
        page = (page == null || page < 0) ? 0 : page;
        size = (size == null || size <= 0) ? 10 : size;
        Pageable pageable = new PageRequest(page, size, sort);
        return pageable;
    }

    /**
     * 获取添加时间降序和分页功能的对象
     *
     * @param page
     * @param size
     * @return
     */
    public static Pageable addTimeSortForDescAndPage(Integer page, Integer size) {
        Sort sort = SortUtil.addTimeSortForDesc();
        return basicPage(page,size,sort);
    }

    /**
     * 获取删除时间降序和分页功能的对象
     *
     * @param page
     * @param size
     * @return
     */
    public static Pageable deletedTimeSortForDescAndPage(Integer page, Integer size) {
        Sort sort = SortUtil.deletedTimeSortForDesc();
        return basicPage(page,size,sort);
    }

    /**
     * 获取删除时间降序和分页功能的对象
     *
     * @param page
     * @param size
     * @return
     */
    public static Pageable publishedTimeSortForDescAndPage(Integer page, Integer size) {
        Sort sort = SortUtil.publishedTimeSortForDesc();
        return basicPage(page,size,sort);
    }

}
