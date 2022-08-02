package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.CvCV;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CvCVDao extends BaseMapper<CvCV> {

    /**
     * 条件查询
     * @param
     * @return
     */
    List<CvCV> selectCVByCondition(CvCV cvCV);

    /**
     * 条件查询
     * @param
     * @return
     */
    List<CvCV> selectCVByConditionLive(CvCV cvCV);

    /**
     * 条件查询
     * @param
     * @return
     */
    List<CvCV> selectCVByConditionDead(CvCV cvCV);

    /**
     * 查询全部声优姓名
     * @param
     * @return
     */
    List<CvCV> selectCVName(CvCV cvCV);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    CvCV selectCVById(Integer id);

    /**
     * 新增声优
     * @param cvCV
     */
    void addCV(CvCV cvCV);

    /**
     * 修改声优信息
     * @param cvCV
     */
    void updateCV(CvCV cvCV);

    /**
     * 声优去世,修改声优信息
     * @param cvCV
     */
    void updateCVdeath(CvCV cvCV);
}
