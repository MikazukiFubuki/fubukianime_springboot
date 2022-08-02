package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.CvCV;

import java.util.List;

public interface CvCVService extends IService<CvCV> {

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
    boolean addCV(CvCV cvCV);

    /**
     * 修改声优信息
     * @param cvCV
     */
    boolean updateCV(CvCV cvCV);

    /**
     * 声优去世,修改声优信息
     * @param cvCV
     */
    boolean updateCVdeath(CvCV cvCV);

    boolean removeById(CvCV cvCV);
}
