package org.jeecg.modules.demo.robot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfig;
import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import org.jeecg.modules.demo.robot.service.IRbLifecirclePushConfigDetailService;
import org.jeecg.modules.demo.robot.service.IRbLifecirclePushConfigService;
import org.jeecg.modules.demo.robot.vo.RbLifecirclePushConfigPage;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @Description: 圈子推送设置
* @Author: jeecg-boot
* @Date:   2022-09-11
* @Version: V1.0
*/
@Api(tags="圈子推送设置")
@RestController
@RequestMapping("/api/config")
@Slf4j
public class ApiPushConfigController {
   @Autowired
   private IRbLifecirclePushConfigService rbLifecirclePushConfigService;
   @Autowired
   private IRbLifecirclePushConfigDetailService rbLifecirclePushConfigDetailService;

   /**
    * 获取机器人推送配置项列表
    *
    * @param robotCode 机器人编号
    * @param req
    * @return 机器人推送配置项列表
    */
   //@AutoLog(value = "圈子推送设置-分页列表查询")
   @ApiOperation(value="获取机器人推送配置项列表", notes="获取机器人推送配置项列表")
   @GetMapping(value = "/getConfigList")
   public Result<List<RbLifecirclePushConfigPage>> getConfigList(String robotCode) {
       LambdaQueryWrapper<RbLifecirclePushConfig> queryWrapper = new LambdaQueryWrapper<>();
       queryWrapper.eq(RbLifecirclePushConfig::getRobotCode, robotCode);
       List<RbLifecirclePushConfig> list = rbLifecirclePushConfigService.list(queryWrapper);

       List<RbLifecirclePushConfigPage> result = new ArrayList<>();

       for (RbLifecirclePushConfig config : list) {
           RbLifecirclePushConfigPage page = new RbLifecirclePushConfigPage();
           BeanUtils.copyProperties(config, page);
           page.setRbLifecirclePushConfigDetailList(rbLifecirclePushConfigDetailService.selectByMainId(config.getId()));
           result.add(page);
       }
       return Result.OK(result);
   }



    @PostMapping(value = "/importConfig")
    public Result importConfig(@RequestBody JSONArray jsonArray) {
        log.info("importConfig");
        log.info(jsonArray.toJSONString());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject item =  jsonArray.getJSONObject(i);
            String name = item.getString("name");
            log.info(name);

            RbLifecirclePushConfig config = new RbLifecirclePushConfig();
            config.setNeedPush("Y");
            config.setNeedCount("Y");
            config.setIsActive("Y");
            config.setLcId(item.getString("lifecircleId"));
            config.setLcName(item.getString("name"));
            config.setTail(item.getString("footer"));
            config.setType(item.getString("lcType"));
            config.setRobotCode("01");


            String[] groups = item.getString("groups").split(",");
            List<RbLifecirclePushConfigDetail> details = new ArrayList<>();
            for (String group : groups) {
                RbLifecirclePushConfigDetail detail = new RbLifecirclePushConfigDetail();

                detail.setGroupName(group);
                detail.setNeedCount("Y");
                details.add(detail);
            }

            rbLifecirclePushConfigService.saveMain(config, details);

        }
        return Result.OK();
    }

}
