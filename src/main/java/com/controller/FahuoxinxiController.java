package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.WuliuxinxiEntity;
import com.service.WuliuxinxiService;
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

import com.entity.FahuoxinxiEntity;

import com.service.FahuoxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 发货表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-22
*/
@RestController
@Controller
@RequestMapping("/fahuoxinxi")
public class FahuoxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(FahuoxinxiController.class);

    @Autowired
    private FahuoxinxiService fahuoxinxiService;

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
            page = fahuoxinxiService.queryPage(params);
        }else{
            page = fahuoxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        FahuoxinxiEntity fahuoxinxi = fahuoxinxiService.selectById(id);
        if(fahuoxinxi!=null){
            return R.ok().put("data", fahuoxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FahuoxinxiEntity fahuoxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<FahuoxinxiEntity> queryWrapper = new EntityWrapper<FahuoxinxiEntity>()
            .eq("logistics", fahuoxinxi.getLogistics());
        fahuoxinxi.setLogistics(String.valueOf(new Date().getTime()));

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FahuoxinxiEntity fahuoxinxiEntity = fahuoxinxiService.selectOne(queryWrapper);
            fahuoxinxi.setShipmentsTime(new Date());
        fahuoxinxi.setYhid((Integer) request.getSession().getAttribute("userId"));
        if(fahuoxinxiEntity==null){
            WuliuxinxiEntity wuliuxinxi = new WuliuxinxiEntity();
            wuliuxinxi.setLogistics(fahuoxinxi.getLogistics());
            wuliuxinxi.setName(fahuoxinxi.getName());
            wuliuxinxi.setWuliu("暂无物流信息");
            wuliuxinxi.setYhid((Integer) request.getSession().getAttribute("userId"));
            wuliuxinxiService.insert(wuliuxinxi);
            fahuoxinxiService.insert(fahuoxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FahuoxinxiEntity fahuoxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<FahuoxinxiEntity> queryWrapper = new EntityWrapper<FahuoxinxiEntity>()
            .notIn("id",fahuoxinxi.getId())
            .eq("logistics", fahuoxinxi.getLogistics())
            .eq("name", fahuoxinxi.getName())
            .eq("kd_types", fahuoxinxi.getKdTypes())
            .eq("addresser", fahuoxinxi.getAddresser())
            .eq("amobile", fahuoxinxi.getAmobile())
            .eq("consigneeaddress", fahuoxinxi.getConsigneeaddress())
            .eq("recipients", fahuoxinxi.getRecipients())
            .eq("rmobile", fahuoxinxi.getRmobile())
            .eq("notice_content", fahuoxinxi.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FahuoxinxiEntity fahuoxinxiEntity = fahuoxinxiService.selectOne(queryWrapper);
        if(fahuoxinxiEntity==null){
            fahuoxinxi.setUpdateTime(new Date());
            fahuoxinxiService.updateById(fahuoxinxi);//根据id更新
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
        fahuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

