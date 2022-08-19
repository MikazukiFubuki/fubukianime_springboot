package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.MusicMain;

import java.util.List;

public interface MusicMainService extends IService<MusicMain> {
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
    boolean addMusicMain(MusicMain musicMain);

    /**
     * 修改音乐
     * @param musicMain
     */
    boolean updateMusicMain(MusicMain musicMain);

    /**
     * 已听音乐
     * @param musicMain
     */
    boolean Listened(MusicMain musicMain);

    boolean removeById(MusicMain musicMain);
}
