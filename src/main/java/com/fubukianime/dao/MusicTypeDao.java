package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.MusicType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicTypeDao extends BaseMapper<MusicType> {


}
