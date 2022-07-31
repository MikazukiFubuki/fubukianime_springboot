package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeEdition;
import com.fubukianime.domain.AnimePeriod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeEditionDao extends BaseMapper<AnimeEdition> {

    /**
     * 查询版本
     * @param
     * @return
     */
    List<AnimeEdition> selectEdition(AnimeEdition animeEdition);

    /**
     * 新增大版本
     * @param animeEdition
     */
    void addLargeEdition(AnimeEdition animeEdition);

    /**
     * 新增大版本
     * @param animeEdition
     */
    void addMinorEdition(AnimeEdition animeEdition);

}
