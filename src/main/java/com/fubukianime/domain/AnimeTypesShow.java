package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnimeTypesShow implements Serializable {

    private static final long serialVersionUID = 8827235867366993400L;

    /**
     * 类型ID
     */
    @TableField(exist = false)
    private Integer id;

    /**
     * 类型细目名
     */
    @TableField(exist = false)
    private String typesName;


    /**
     * 类型细目计数
     */
    @TableField(exist = false)
    private Integer typesNum;

    /**
     * 类型细目计数
     */
    @TableField(exist = false)
    private Integer series;


}
