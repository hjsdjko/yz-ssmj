package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShoujianxinxiDao;
import com.entity.ShoujianxinxiEntity;
import com.service.ShoujianxinxiService;
import com.entity.view.ShoujianxinxiView;

/**
 * 快递仓库信息表 服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("shoujianxinxiService")
@Transactional
public class ShoujianxinxiServiceImpl extends ServiceImpl<ShoujianxinxiDao, ShoujianxinxiEntity> implements ShoujianxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShoujianxinxiView> page =new Query<ShoujianxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
