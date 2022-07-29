package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimePeriod;
import com.fubukianime.domain.AnimeQuarter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeQuarterDao extends BaseMapper<AnimeQuarter> {


    /**
     * 查询较季
     * @param
     * @return
     */
    List<AnimeQuarter> selectComQuarter(AnimeQuarter animeQuarter);


    /**
     * 新增较季点
     * @param animeQuarter
     */
    void addComQuarter(AnimeQuarter animeQuarter);

}
