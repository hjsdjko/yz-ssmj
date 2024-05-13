package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.FahuoxinxiDao;
import com.entity.FahuoxinxiEntity;
import com.service.FahuoxinxiService;
import com.entity.view.FahuoxinxiView;

/**
 * 发货表 服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("fahuoxinxiService")
@Transactional
public class FahuoxinxiServiceImpl extends ServiceImpl<FahuoxinxiDao, FahuoxinxiEntity> implements FahuoxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FahuoxinxiView> page =new Query<FahuoxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
