package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.CvWorks;

import java.util.List;

public interface CvWorksService extends IService<CvWorks> {
    /**
     * 条件查询
     * @param
     * @return
     */
    List<CvWorks> selectCvWorks(CvWorks cvWorks);

    /**
     * 新增后条件查询
     * @param
     * @return
     */
    List<CvWorks> selectAfterAdd(CvWorks cvWorks);

    /**
     * 修改删除后条件查询
     * @param
     * @return
     */
    List<CvWorks> selectAfterUpdate(CvWorks cvWorks);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    CvWorks selectCvWorksById(Integer id);

    /**
     * 新增角色前查验查询
     * @param cvWorks
     * @return
     */
    CvWorks checkCvWorks(CvWorks cvWorks);

    /**
     * 新增角色
     * @param cvWorks
     */
    boolean addCvWorks(CvWorks cvWorks);

    /**
     * 修改角色
     * @param cvWorks
     */
    boolean updateCvWorks(CvWorks cvWorks);

    /**
     * 修改年份
     * @param cvWorks
     */
    boolean updateYear(CvWorks cvWorks);

    /**
     * 修改角色
     * @param cvWorks
     */
    boolean updateRole(CvWorks cvWorks);

    boolean removeById(CvWorks cvWorks);
}
