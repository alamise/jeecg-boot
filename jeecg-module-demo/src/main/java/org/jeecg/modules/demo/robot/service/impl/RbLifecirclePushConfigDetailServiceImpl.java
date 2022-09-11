package org.jeecg.modules.demo.robot.service.impl;

import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import org.jeecg.modules.demo.robot.mapper.RbLifecirclePushConfigDetailMapper;
import org.jeecg.modules.demo.robot.service.IRbLifecirclePushConfigDetailService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 圈子推送配置明细
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
@Service
public class RbLifecirclePushConfigDetailServiceImpl extends ServiceImpl<RbLifecirclePushConfigDetailMapper, RbLifecirclePushConfigDetail> implements IRbLifecirclePushConfigDetailService {
	
	@Autowired
	private RbLifecirclePushConfigDetailMapper rbLifecirclePushConfigDetailMapper;
	
	@Override
	public List<RbLifecirclePushConfigDetail> selectByMainId(String mainId) {
		return rbLifecirclePushConfigDetailMapper.selectByMainId(mainId);
	}
}
