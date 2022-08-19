package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.MusicMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMainDao extends BaseMapper<MusicMain> {
    /**
     * 条件查询
     * @param
     * @return
     */
    List<MusicMain> selectMusicMain(MusicMain musicMain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    MusicMain selectMusicMainById(Integer id);

    /**
     * 新增音乐
     * @param musicMain
     */
    void addMusicMain(MusicMain musicMain);

    /**
     * 已听音乐
     * @param musicMain
     */
    void Listened(MusicMain musicMain);

    /**
     * 修改音乐
     * @param musicMain
     */
    void updateMusicMain(MusicMain musicMain);

    /**
     * 根据id修改音乐编号
     * @param musicMain
     */
    void updateMIDBYId(MusicMain musicMain);

    /**
     * 根据音乐编号查找id
     * @param musicMain
     */
    Integer selectIdByMID(MusicMain musicMain);

    /**
     * 查找最大id
     * @param
     * @return
     */
    Integer selectMaxMId();
}
