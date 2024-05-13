package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.WuliuxinxiEntity;

import com.service.WuliuxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-02-22
*/
@RestController
@Controller
@RequestMapping("/wuliuxinxi")
public class WuliuxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(WuliuxinxiController.class);

    @Autowired
    private WuliuxinxiService wuliuxinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = wuliuxinxiService.queryPage(params);
        }else{
            page = wuliuxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        WuliuxinxiEntity wuliuxinxi = wuliuxinxiService.selectById(id);
        if(wuliuxinxi!=null){
            return R.ok().put("data", wuliuxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuliuxinxiEntity wuliuxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<WuliuxinxiEntity> queryWrapper = new EntityWrapper<WuliuxinxiEntity>()
            .eq("logistics", wuliuxinxi.getLogistics())
            .eq("name", wuliuxinxi.getName())
            .eq("wuliu", wuliuxinxi.getWuliu())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliuxinxiEntity wuliuxinxiEntity = wuliuxinxiService.selectOne(queryWrapper);
        if(wuliuxinxiEntity==null){
            wuliuxinxiService.insert(wuliuxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuliuxinxiEntity wuliuxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<WuliuxinxiEntity> queryWrapper = new EntityWrapper<WuliuxinxiEntity>()
            .notIn("id",wuliuxinxi.getId())
            .eq("logistics", wuliuxinxi.getLogistics())
            .eq("name", wuliuxinxi.getName())
            .eq("wuliu", wuliuxinxi.getWuliu())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliuxinxiEntity wuliuxinxiEntity = wuliuxinxiService.selectOne(queryWrapper);
        if(wuliuxinxiEntity==null){
            wuliuxinxiService.updateById(wuliuxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        wuliuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

