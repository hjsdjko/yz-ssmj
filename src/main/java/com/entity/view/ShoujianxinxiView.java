package com.entity.view;

import com.entity.ShoujianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 快递仓库信息表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("shoujianxinxi")
public class ShoujianxinxiView extends ShoujianxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShoujianxinxiView() {

	}

	public ShoujianxinxiView(ShoujianxinxiEntity shoujianxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, shoujianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
