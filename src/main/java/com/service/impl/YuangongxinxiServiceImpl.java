package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YuangongxinxiDao;
import com.entity.YuangongxinxiEntity;
import com.service.YuangongxinxiService;
import com.entity.view.YuangongxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("yuangongxinxiService")
@Transactional
public class YuangongxinxiServiceImpl extends ServiceImpl<YuangongxinxiDao, YuangongxinxiEntity> implements YuangongxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YuangongxinxiView> page =new Query<YuangongxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
