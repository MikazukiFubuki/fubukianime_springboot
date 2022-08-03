package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.MusicEdition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicEditionDao extends BaseMapper<MusicEdition> {

    /**
     * 查询版本
     * @param
     * @return
     */
    List<MusicEdition> selectEdition(MusicEdition musicEdition);

    /**
     * 新增大版本
     * @param musicEdition
     */
    void addLargeEdition(MusicEdition musicEdition);

    /**
     * 新增大版本
     * @param musicEdition
     */
    void addMinorEdition(MusicEdition musicEdition);

}
