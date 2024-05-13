package com.entity.model;

import com.entity.WuliuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-22
 */
public class WuliuxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物流单号
     */
    private String logistics;


    /**
     * 快递名称
     */
    private String name;


    /**
     * 物流信息
     */
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
