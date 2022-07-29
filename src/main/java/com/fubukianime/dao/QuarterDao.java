package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.domain.Quarter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuarterDao extends BaseMapper<Quarter> {



}
