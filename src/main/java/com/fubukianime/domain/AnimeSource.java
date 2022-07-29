package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_source")
public class AnimeSource implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("source")
    private String source;
    @TableField("`debut`")
    private String debut;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
