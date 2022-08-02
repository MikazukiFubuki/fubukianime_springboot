package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("cv_works")
public class CvWorks implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("cv_id")
    private Integer cvId;

    @TableField("anime_name")
    private String animeName;

    @TableField("anime_role")
    private String animeRole;

    @TableField("start_year")
    private String startYear;

    @TableField("end_year")
    private String endYear;

    @TableField(exist = false)
    private String year;

    @TableField(exist = false)
    private String cvName;



    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
