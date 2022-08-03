package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameMain;

import java.util.List;

public interface GalGameMainService extends IService<GalGameMain> {
    /**
     * 条件查询
     * @param
     * @return
     */
    List<GalGameMain> selectGalGameMain(GalGameMain galGameMain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    GalGameMain selectGalGameMainById(Integer id);

    /**
     * 新增角色
     * @param galGameMain
     */
    boolean addGalGameMain(GalGameMain galGameMain);

    /**
     * 修改角色
     * @param galGameMain
     */
    boolean updateGalGameMain(GalGameMain galGameMain);

    boolean removeById(GalGameMain galGameMain);
}
