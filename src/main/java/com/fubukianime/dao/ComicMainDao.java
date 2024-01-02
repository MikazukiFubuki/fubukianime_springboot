package com.fubukianime.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.ComicMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wyx
 * @description 针对表【anime_main】的数据库操作Mapper
 * @createDate 2022-07-14 15:07:06
 * @Entity generator.domain.AnimeMain
 */
@Mapper
public interface ComicMainDao extends BaseMapper<ComicMain> {

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
     * 新增漫画
     * @param comicMain
     */
    void addComic(ComicMain comicMain);


    /**
     * 修改漫画信息
     * @param comicMain
     */
    void updateComic(ComicMain comicMain);

    /**
     * 对已追漫画追更一集
     * @param comicMain
     */
    void chasingAPlay(ComicMain comicMain);











}
