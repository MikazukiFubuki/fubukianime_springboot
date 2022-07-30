package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeShowDao extends BaseMapper<AnimeShow> {


    /**
     * 查询信息
     * @param
     * @return
     */
    List<AnimeShow> selectAnimeShow(AnimeShow animeShow);



}
