package org.jeecg.modules.demo.robot.service.impl;

import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfig;
import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import org.jeecg.modules.demo.robot.mapper.RbLifecirclePushConfigDetailMapper;
import org.jeecg.modules.demo.robot.mapper.RbLifecirclePushConfigMapper;
import org.jeecg.modules.demo.robot.service.IRbLifecirclePushConfigService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 圈子推送设置
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
@Service
public class RbLifecirclePushConfigServiceImpl extends ServiceImpl<RbLifecirclePushConfigMapper, RbLifecirclePushConfig> implements IRbLifecirclePushConfigService {

	@Autowired
	private RbLifecirclePushConfigMapper rbLifecirclePushConfigMapper;
	@Autowired
	private RbLifecirclePushConfigDetailMapper rbLifecirclePushConfigDetailMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(RbLifecirclePushConfig rbLifecirclePushConfig, List<RbLifecirclePushConfigDetail> rbLifecirclePushConfigDetailList) {
		rbLifecirclePushConfigMapper.insert(rbLifecirclePushConfig);
		if(rbLifecirclePushConfigDetailList!=null && rbLifecirclePushConfigDetailList.size()>0) {
			for(RbLifecirclePushConfigDetail entity:rbLifecirclePushConfigDetailList) {
				//外键设置
				entity.setLcConfigId(rbLifecirclePushConfig.getId());
				rbLifecirclePushConfigDetailMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(RbLifecirclePushConfig rbLifecirclePushConfig,List<RbLifecirclePushConfigDetail> rbLifecirclePushConfigDetailList) {
		rbLifecirclePushConfigMapper.updateById(rbLifecirclePushConfig);
		
		//1.先删除子表数据
		rbLifecirclePushConfigDetailMapper.deleteByMainId(rbLifecirclePushConfig.getId());
		
		//2.子表数据重新插入
		if(rbLifecirclePushConfigDetailList!=null && rbLifecirclePushConfigDetailList.size()>0) {
			for(RbLifecirclePushConfigDetail entity:rbLifecirclePushConfigDetailList) {
				//外键设置
				entity.setLcConfigId(rbLifecirclePushConfig.getId());
				rbLifecirclePushConfigDetailMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		rbLifecirclePushConfigDetailMapper.deleteByMainId(id);
		rbLifecirclePushConfigMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			rbLifecirclePushConfigDetailMapper.deleteByMainId(id.toString());
			rbLifecirclePushConfigMapper.deleteById(id);
		}
	}
	
}
