package com.fubukianime.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.MusicEdition;

import java.util.List;


public interface MusicEditionService extends IService<MusicEdition> {


    boolean addLargeEdition(MusicEdition musicEdition);

    boolean addMinorEdition(MusicEdition musicEdition);

    List<MusicEdition> selectEdition(MusicEdition musicEdition);




}
