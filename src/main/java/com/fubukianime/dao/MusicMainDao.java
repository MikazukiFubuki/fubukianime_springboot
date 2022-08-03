package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * 修改音乐
     * @param musicMain
     */
    void updateMusicMain(MusicMain musicMain);
}
