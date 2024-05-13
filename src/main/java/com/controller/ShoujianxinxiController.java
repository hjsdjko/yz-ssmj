package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CangkuxinxiEntity;
import com.service.CangkuxinxiService;
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

import com.entity.ShoujianxinxiEntity;

import com.service.ShoujianxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递仓库信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-22
*/
@RestController
@Controller
@RequestMapping("/shoujianxinxi")
public class ShoujianxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ShoujianxinxiController.class);

    @Autowired
    private ShoujianxinxiService shoujianxinxiService;


    @Autowired
    private CangkuxinxiService cangkuxinxiService;

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
            page = shoujianxinxiService.queryPage(params);
        }else{
            page = shoujianxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShoujianxinxiEntity shoujianxinxi = shoujianxinxiService.selectById(id);
        if(shoujianxinxi!=null){
            return R.ok().put("data", shoujianxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShoujianxinxiEntity shoujianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShoujianxinxiEntity> queryWrapper = new EntityWrapper<ShoujianxinxiEntity>()
            .eq("logistics", shoujianxinxi.getLogistics());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShoujianxinxiEntity shoujianxinxiEntity = shoujianxinxiService.selectOne(queryWrapper);
            shoujianxinxi.setAddresseeTime(new Date());
        shoujianxinxi.setYhid((Integer) request.getSession().getAttribute("userId"));
        if(shoujianxinxi.getNoticeContent()==null || shoujianxinxi.getNoticeContent() == ""){
            shoujianxinxi.setNoticeContent("暂无备注信息");
        }
        CangkuxinxiEntity cangkuxinxi = cangkuxinxiService.selectOne(new EntityWrapper<CangkuxinxiEntity>()
                .eq("logistics",shoujianxinxi.getLogistics()));
        cangkuxinxi.setExpressTypes(1);
        if(shoujianxinxiEntity==null){
            cangkuxinxiService.updateById(cangkuxinxi);
            shoujianxinxiService.insert(shoujianxinxi);
            return R.ok();
        }else {
            return R.error(511,"您已经签收过了，请不要重复签收");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShoujianxinxiEntity shoujianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShoujianxinxiEntity> queryWrapper = new EntityWrapper<ShoujianxinxiEntity>()
            .notIn("id",shoujianxinxi.getId())
            .eq("logistics", shoujianxinxi.getLogistics())
            .eq("name", shoujianxinxi.getName())
            .eq("kd_types", shoujianxinxi.getKdTypes())
            .eq("recipients", shoujianxinxi.getRecipients())
            .eq("rmobile", shoujianxinxi.getRmobile())
            .eq("consigneeaddress", shoujianxinxi.getConsigneeaddress())
            .eq("notice_content", shoujianxinxi.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShoujianxinxiEntity shoujianxinxiEntity = shoujianxinxiService.selectOne(queryWrapper);
        if(shoujianxinxiEntity==null){
            shoujianxinxi.setUpdateTime(new Date());
            shoujianxinxiService.updateById(shoujianxinxi);//根据id更新
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
        shoujianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

