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
 * 快递仓库信息表
 *
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("cangkuxinxi")
public class CangkuxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CangkuxinxiEntity() {

	}

	public CangkuxinxiEntity(T t) {
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


    /**
     * 物流单号
     */
    @TableField(value = "logistics")
    private String logistics;


    /**
     * 快递名称 Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 快递类型 Search
     */
    @TableField(value = "kd_types")
    private Integer kdTypes;


    /**
     * 送件人
     */
    @TableField(value = "courier")
    private String courier;


    /**
     * 手机号
     */
    @TableField(value = "cmobile")
    private String cmobile;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "warehouse_time")
    private Date warehouseTime;


    /**
     * 收件人
     */
    @TableField(value = "recipients")
    private String recipients;


    /**
     * 手机号
     */
    @TableField(value = "rmobile")
    private String rmobile;


    /**
     * 收件地址
     */
    @TableField(value = "consigneeaddress")
    private String consigneeaddress;


    /**
     * 快递状态 Search
     */
    @TableField(value = "express_types")
    private Integer expressTypes;


    /**
     * 描述信息
     */
    @TableField(value = "notice_content")
    private String noticeContent;


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
	 * 设置：快递名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：快递名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：快递类型 Search
	 */
    public Integer getKdTypes() {
        return kdTypes;
    }


    /**
	 * 获取：快递类型 Search
	 */

    public void setKdTypes(Integer kdTypes) {
        this.kdTypes = kdTypes;
    }
    /**
	 * 设置：送件人
	 */
    public String getCourier() {
        return courier;
    }


    /**
	 * 获取：送件人
	 */

    public void setCourier(String courier) {
        this.courier = courier;
    }
    /**
	 * 设置：手机号
	 */
    public String getCmobile() {
        return cmobile;
    }


    /**
	 * 获取：手机号
	 */

    public void setCmobile(String cmobile) {
        this.cmobile = cmobile;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getWarehouseTime() {
        return warehouseTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setWarehouseTime(Date warehouseTime) {
        this.warehouseTime = warehouseTime;
    }
    /**
	 * 设置：收件人
	 */
    public String getRecipients() {
        return recipients;
    }


    /**
	 * 获取：收件人
	 */

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }
    /**
	 * 设置：手机号
	 */
    public String getRmobile() {
        return rmobile;
    }


    /**
	 * 获取：手机号
	 */

    public void setRmobile(String rmobile) {
        this.rmobile = rmobile;
    }
    /**
	 * 设置：收件地址
	 */
    public String getConsigneeaddress() {
        return consigneeaddress;
    }


    /**
	 * 获取：收件地址
	 */

    public void setConsigneeaddress(String consigneeaddress) {
        this.consigneeaddress = consigneeaddress;
    }
    /**
	 * 设置：快递状态 Search
	 */
    public Integer getExpressTypes() {
        return expressTypes;
    }


    /**
	 * 获取：快递状态 Search
	 */

    public void setExpressTypes(Integer expressTypes) {
        this.expressTypes = expressTypes;
    }
    /**
	 * 设置：描述信息
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：描述信息
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

}
