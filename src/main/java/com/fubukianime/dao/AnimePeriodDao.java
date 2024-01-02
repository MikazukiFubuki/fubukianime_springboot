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
     * 查询补完时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectCPeriod(AnimePeriod animePeriod);

    /**
     * 查询实际补时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectRCPeriod(AnimePeriod animePeriod);

    /**
     * 查询追番时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectBPeriod(AnimePeriod animePeriod);

    /**
     * 查询年终时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectYPeriod(AnimePeriod animePeriod);

    /**
     * 新增时期点
     * @param animePeriod
     */
    void addPeriod(AnimePeriod animePeriod);

}
