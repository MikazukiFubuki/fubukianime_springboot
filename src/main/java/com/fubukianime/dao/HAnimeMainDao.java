package com.fubukianime.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMainQuery;
import com.fubukianime.domain.HAnimeMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wyx
 * @description 针对表【anime_main】的数据库操作Mapper
 * @createDate 2022-07-14 15:07:06
 * @Entity generator.domain.AnimeMain
 */
@Mapper
public interface HAnimeMainDao extends BaseMapper<HAnimeMain> {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    HAnimeMain selectMainById(Integer id);


    /**
     * 条件查询
     * @param
     * @return
     */
    List<HAnimeMain> selectMainByCondition(HAnimeMain hAnimeMain);

    /**
     * 新增动画
     * @param hAnimeMain
     */
    void addHAnime(HAnimeMain hAnimeMain);


    /**
     * 修改动画信息
     * @param hAnimeMain
     */
    void updateHAnime(HAnimeMain hAnimeMain);

    /**
     * 对已追动画追更一集
     * @param hAnimeMain
     */
    void chasingAPlay(HAnimeMain hAnimeMain);











}
