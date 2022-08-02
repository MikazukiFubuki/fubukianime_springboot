package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("cv_cv")
public class CvCV implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;

    @TableField("hiragana")
    private String hiragana;

    @TableField("sex")
    private String sex;

    @TableField("another_name")
    private String anotherName;

    @TableField("birthday")
    private String birthday;

    @TableField("company")
    private String company;

    @TableField("debut_year")
    private String debutYear;

    @TableField("lived")
    private Integer lived;

    @TableField("death_day")
    private String deathDay;

    @TableField(exist = false)
    private Integer roleNum;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
