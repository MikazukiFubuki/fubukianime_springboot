package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName anime_main
 */
@TableName(value ="anime_main")
@Data
public class AnimeMain implements Serializable {
    /**
     * 动画表id（主键）
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 动画片名
     */
    @TableField("name")
    private String name;

    /**
     * 动画评分
     */
    @TableField("score")
    private Double score;

    /**
     * 动画片源1
     */
    @TableField("source_1")
    private String source1;

    /**
     * 动画片源2
     */
    @TableField("source_2")
    private String source2;

    /**
     * 动画片源3
     */
    @TableField("source_3")
    private String source3;

    /**
     * 动画类型1
     */
    @TableField("type_1")
    private String type1;

    /**
     * 动画类型2
     */
    @TableField("type_2")
    private String type2;

    /**
     * 动画类型3
     */
    @TableField("type_3")
    private String type3;

    /**
     * 动画补完序号
     */
    @TableField("complete_id")
    private Integer completeId;

    /**
     * 动画追番情况
     */
    @TableField("binge_watching_type")
    private String bingeWatchingType;

    /**
     * 动画原作结局
     */
    @TableField("original_end")
    private String originalEnd;

    /**
     * 动画状态
     */
    @TableField("status")
    private String status;

    /**
     * 动画播出最终年份
     */
    @TableField("broadcast_end_year")
    private String broadcastEndYear;

    /**
     * 动画最爱女主
     */
    @TableField("favorite_heroine")
    private String favoriteHeroine;

    /**
     * 动画追番序号
     */
    @TableField("binge_watching_id")
    private Integer bingeWatchingId;

    /**
     * 动画创作类型
     */
    @TableField("`create`")
    private String create;

    /**
     * 动画工口类型
     */
    @TableField("sex_limit")
    private String sexLimit;

    /**
     * 动画补完季
     */
    @TableField("complete_quarter")
    private String completeQuarter;

    /**
     * 动画追番季
     */
    @TableField("binge_watching_quarter")
    private String bingeWatchingQuarter;

    /**
     * 动画播出起始年份
     */
    @TableField("broadcast_start_year")
    private String broadcastStartYear;

    /**
     * 动画结局
     */
    @TableField("animation_end")
    private String animationEnd;

    /**
     * 动画主角类型
     */
    @TableField("leader_gender")
    private String leaderGender;

    /**
     * 动画重温序号
     */
    @TableField("review_id")
    private Integer reviewId;

    /**
     * 动画恋爱类型
     */
    @TableField("love")
    private String love;

    /**
     * 动画形式id
     */
    @TableField("layout_id")
    private String layoutId;

    /**
     * 动画形式
     */
    @TableField(exist = false)
    private String layout;

    /**
     * 动画追番年
     */
    @TableField("binge_watching_year")
    private String bingeWatchingYear;

    /**
     * 动画补完年
     */
    @TableField("complete_year")
    private String completeYear;

    /**
     * 动画播出年份
     */
    @TableField(exist = false)
    private String broadcastYear;

    /**
     * 动画来源集合
     */
    @TableField(exist = false)
    private String source;
    /**
     * 动画类型集合
     */
    @TableField(exist = false)
    private String type;

    /**
     * 要修改后的追补重番id
     */
    @TableField(exist = false)
    private Integer modifyId;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;

}