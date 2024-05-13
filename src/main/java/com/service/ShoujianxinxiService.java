package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShoujianxinxiEntity;
import java.util.Map;

/**
 * 快递仓库信息表 服务类
 * @author 
 * @since 2021-02-22
 */
public interface ShoujianxinxiService extends IService<ShoujianxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}