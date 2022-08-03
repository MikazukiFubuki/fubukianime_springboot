package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.GalGameMain;
import com.fubukianime.domain.MusicMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalGameMainDao extends BaseMapper<GalGameMain> {
    /**
     * 条件查询
     * @param
     * @return
     */
    List<GalGameMain> selectGalGameMain(GalGameMain galGameMain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    GalGameMain selectGalGameMainById(Integer id);

    /**
     * 新增GalGame
     * @param galGameMain
     */
    void addGalGameMain(GalGameMain galGameMain);

    /**
     * 修改GalGame
     * @param galGameMain
     */
    void updateGalGameMain(GalGameMain galGameMain);
}
