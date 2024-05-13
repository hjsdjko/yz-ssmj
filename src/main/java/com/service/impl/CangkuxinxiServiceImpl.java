package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.CangkuxinxiDao;
import com.entity.CangkuxinxiEntity;
import com.service.CangkuxinxiService;
import com.entity.view.CangkuxinxiView;

/**
 * 快递仓库信息表 服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("cangkuxinxiService")
@Transactional
public class CangkuxinxiServiceImpl extends ServiceImpl<CangkuxinxiDao, CangkuxinxiEntity> implements CangkuxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CangkuxinxiView> page =new Query<CangkuxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
