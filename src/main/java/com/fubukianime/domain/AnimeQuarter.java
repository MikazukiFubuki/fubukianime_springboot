package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_quarter")
public class AnimeQuarter implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("years")
    private String years;
    @TableField("quarter")
    private String quarter;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;

    /**
     * 追番季
     */
    @TableField(exist = false)
    private String bingeWatchingQuarter;

    /**
     * 当季追番和
     */
    @TableField(exist = false)
    private Integer bingeWatchingSUM;

    /**
     * 较上季追番数比
     */
    @TableField(exist = false)
    private String bingeWatchingCompare;

    /**
     * 当季追番数
     */
    @TableField(exist = false)
    private Integer currentSeasonNum;

    /**
     * 跨季追番数
     */
    @TableField(exist = false)
    private Integer lastSeasonNum;

    /**
     * 停播追番数
     */
    @TableField(exist = false)
    private Integer stopLiveNum;

    /**
     * 当季追番平均分
     */
    @TableField(exist = false)
    private Double averageScore;

}
