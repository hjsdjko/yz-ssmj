package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("wuliuxinxi")
public class WuliuxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuliuxinxiEntity() {

	}

	public WuliuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    @TableField(value = "yhid")
    private Integer yhid;


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

    public Integer getYhid() {
        return yhid;
    }

    public void setYhid(Integer yhid) {
        this.yhid = yhid;
    }

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
