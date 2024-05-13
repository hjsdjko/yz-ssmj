package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.WuliuxinxiDao;
import com.entity.WuliuxinxiEntity;
import com.service.WuliuxinxiService;
import com.entity.view.WuliuxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("wuliuxinxiService")
@Transactional
public class WuliuxinxiServiceImpl extends ServiceImpl<WuliuxinxiDao, WuliuxinxiEntity> implements WuliuxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<WuliuxinxiView> page =new Query<WuliuxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
