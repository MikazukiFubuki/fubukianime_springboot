package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeEdition;

import java.util.List;


public interface AnimeEditionService extends IService<AnimeEdition> {


    boolean addLargeEdition(AnimeEdition animeEdition);

    boolean addMinorEdition(AnimeEdition animeEdition);

    List<AnimeEdition> selectEdition(AnimeEdition animeEdition);




}
