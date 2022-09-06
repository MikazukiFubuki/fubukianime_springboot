package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.CvWorks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CvWorksDao extends BaseMapper<CvWorks> {
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
     * 根据id查询
     * @param id
     * @return
     */
    CvWorks selectCvWorksById(Integer id);

    /**
     * 新增角色
     * @param cvWorks
     */
    void addCvWorks(CvWorks cvWorks);

    /**
     * 修改角色
     * @param cvWorks
     */
    void updateCvWorks(CvWorks cvWorks);

    /**
     * 修改年份
     * @param cvWorks
     */
    void updateYear(CvWorks cvWorks);

    /**
     * 修改角色
     * @param cvWorks
     */
    void updateRole(CvWorks cvWorks);
}
