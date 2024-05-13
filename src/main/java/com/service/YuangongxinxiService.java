package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-22
 */
public interface YuangongxinxiService extends IService<YuangongxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}