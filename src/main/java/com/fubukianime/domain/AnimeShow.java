package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnimeShow implements Serializable {

    /**
     * 已补番数
     */
    @TableField(exist = false)
    private Integer maxCompleteId;

    /**
     * 已追番数
     */
    @TableField(exist = false)
    private Integer maxBingeWatchingId;

    /**
     * 实际已补番数
     */
    @TableField(exist = false)
    private Integer reaCompleteId;

    /**
     * 日漫接触日（君名）
     */
    @TableField(exist = false)
    private String aniYourName;

    /**
     * 入宅纪念日（EVA）
     */
    @TableField(exist = false)
    private String aniEva;

    /**
     * 二次元时长
     */
    @TableField(exist = false)
    private Integer aniTime;

    /**
     * 平均日补番数
     */
    @TableField(exist = false)
    private Double avgCompleteId;

    /**
     * 平均日追番数
     */
    @TableField(exist = false)
    private Double avgBingeWatchingId;

    /**
     * 平均日实际已补番数
     */
    @TableField(exist = false)
    private Double avgReaCompleteId;
}
