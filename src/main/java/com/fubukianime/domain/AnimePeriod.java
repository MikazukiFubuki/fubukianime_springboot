package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("anime_period")
public class AnimePeriod implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 区别是否特殊时间点后id
     */
    @TableField("spid")
    private Integer spid;

    /**
     * 结束日期
     */
    @TableField("period")
    private Date period;

    /**
     * 结束日期
     */
    @TableField("exist = false")
    private String periods;

    /**
     * 结束时间点
     */
    @TableField("period_name")
    private String periodName;

    /**
     * 已补番数
     */
    @TableField("complete_amount")
    private Integer completeAmount;

    /**
     * 已追番数
     */
    @TableField("binge_watching_amount")
    private Integer bingeWatchingAmount;

    /**
     * 实际已补番数
     */
    @TableField(exist = false)
    private Integer reCompleteAmount;

    /**
     * 判断是否特殊时间点
     */
    @TableField("sp")
    private Integer sp;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;

    /**
     * 期间补番
     */
    @TableField(exist = false)
    private Integer periodComplete;

    /**
     * 期间追番
     */
    @TableField(exist = false)
    private Integer periodBingeWatching;

    /**
     * 较上期补番
     */
    @TableField(exist = false)
    private String comparePeriodComplete;

    /**
     * 较上期追番
     */
    @TableField(exist = false)
    private String comparePeriodBingeWatching;

    /**
     * 平均日补番
     */
    @TableField(exist = false)
    private Double averageDailyComplete;

    /**
     * 平均日追番
     */
    @TableField(exist = false)
    private Double averageDailyBingeWatching;

    /**
     * 日数
     */
    @TableField(exist = false)
    private Integer days;

    /**
     * 较上期平均日补番
     */
    @TableField(exist = false)
    private String comparePeriodAverageDailyComplete;

    /**
     * 较上期平均日追番
     */
    @TableField(exist = false)
    private String comparePeriodAverageDailyBingeWatching;

    /**
     * 期间补番平均分
     */
    @TableField(exist = false)
    private Double averageScoreComplete;

    /**
     * averageScoreBingeWatching
     */
    @TableField(exist = false)
    private Double averageScoreBingeWatching;
}
