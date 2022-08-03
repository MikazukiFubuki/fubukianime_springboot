package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("galgame_main")
public class GalGameMain implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField(exist = false)
    private Double allScore;

    @TableField("story_score")
    private Integer storyScore;

    @TableField("role_score")
    private Integer roleScore;

    @TableField("img_quality_score")
    private Integer imgQualityScore;

    @TableField("music_score")
    private Integer musicScore;

    @TableField("environment_type")
    private String environmentType;

    @TableField("type")
    private String type;

    @TableField("reborn_type")
    private String rebornType;

    @TableField("love_type")
    private String loveType;

    @TableField("branch_type")
    private String branchType;

    @TableField("sp_type")
    private String spType;

    @TableField("sex_level")
    private String sexLevel;

    @TableField("language")
    private String language;

    @TableField("area")
    private String area;

    @TableField("status")
    private String status;


    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
