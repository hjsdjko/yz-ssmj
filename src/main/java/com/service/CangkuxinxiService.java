package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CangkuxinxiEntity;
import java.util.Map;

/**
 * 快递仓库信息表 服务类
 * @author 
 * @since 2021-02-22
 */
public interface CangkuxinxiService extends IService<CangkuxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}