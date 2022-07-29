package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_bingewatchingtype")
public class AnimeBingeWatchingType implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("binge_watching_type")
    private String bingeWatchingType;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
