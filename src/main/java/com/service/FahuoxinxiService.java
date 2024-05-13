package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FahuoxinxiEntity;
import java.util.Map;

/**
 * 发货表 服务类
 * @author 
 * @since 2021-02-22
 */
public interface FahuoxinxiService extends IService<FahuoxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}