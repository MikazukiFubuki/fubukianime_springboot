package com.fubukianime.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeShow;

import java.util.List;


public interface AnimeShowService extends IService<AnimeShow> {

    /**
     * 查询信息
     * @param
     * @return
     */
    List<AnimeShow> selectAnimeShow(AnimeShow animeShow);




}
