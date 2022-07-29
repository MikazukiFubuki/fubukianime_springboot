package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("quarter")
public class Quarter implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("quarter")
    private String quarter;
    @TableField("quarter_CN")
    private String quarterCN;

}
