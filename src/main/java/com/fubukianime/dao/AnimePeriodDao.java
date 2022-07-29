package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimePeriod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimePeriodDao extends BaseMapper<AnimePeriod> {

    /**
     * 查询普通时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectComPeriod(AnimePeriod animePeriod);

    /**
     * 查询特殊时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectSPPeriod(AnimePeriod animePeriod);

    /**
     * 新增时期点
     * @param animePeriod
     */
    void addPeriod(AnimePeriod animePeriod);

}
