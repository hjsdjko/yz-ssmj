package com.dao;

import com.entity.CangkuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CangkuxinxiView;

/**
 * 快递仓库信息表 Dao 接口
 *
 * @author 
 * @since 2021-02-22
 */
public interface CangkuxinxiDao extends BaseMapper<CangkuxinxiEntity> {

   List<CangkuxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
