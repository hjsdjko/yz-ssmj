package com.dao;

import com.entity.FahuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FahuoxinxiView;

/**
 * 发货表 Dao 接口
 *
 * @author 
 * @since 2021-02-22
 */
public interface FahuoxinxiDao extends BaseMapper<FahuoxinxiEntity> {

   List<FahuoxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
