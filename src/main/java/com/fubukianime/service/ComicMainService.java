package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.ComicMain;

import java.util.List;

public interface ComicMainService extends IService<ComicMain> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    ComicMain selectMainById(Integer id);


    /**
     * 条件查询
     * @param
     * @return
     */
    List<ComicMain> selectMainByCondition(ComicMain comicMain);

    /**
     * 新增动画
     * @param comicMain
     */
    boolean addComic(ComicMain comicMain);


    /**
     * 修改动画信息
     * @param comicMain
     */
    boolean updateComic(ComicMain comicMain);

    /**
     * 对已追动画追更一集
     * @param comicMain
     */
    boolean chasingAPlay(ComicMain comicMain);

    boolean removeById(ComicMain comicMain);
}
