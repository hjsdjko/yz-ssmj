package com.entity.vo;

import com.entity.WuliuxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("wuliuxinxi")
public class WuliuxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物流单号
     */

    @TableField(value = "logistics")
    private String logistics;


    /**
     * 快递名称
     */

    @TableField(value = "name")
    private String name;


    /**
     * 物流信息
     */

    @TableField(value = "wuliu")
    private String wuliu;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：物流单号
	 */
    public String getLogistics() {
        return logistics;
    }


    /**
	 * 获取：物流单号
	 */

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }
    /**
	 * 设置：快递名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：快递名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：物流信息
	 */
    public String getWuliu() {
        return wuliu;
    }


    /**
	 * 获取：物流信息
	 */

    public void setWuliu(String wuliu) {
        this.wuliu = wuliu;
    }

}
