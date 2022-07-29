package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_originalend")
public class AnimeOriginalEnd implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("original_end")
    private String originalEnd;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
