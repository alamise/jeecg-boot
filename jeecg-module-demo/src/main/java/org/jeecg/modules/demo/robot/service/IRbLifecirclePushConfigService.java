package org.jeecg.modules.demo.robot.service;

import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 圈子推送设置
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
public interface IRbLifecirclePushConfigService extends IService<RbLifecirclePushConfig> {

	/**
	 * 添加一对多
	 *
	 * @param rbLifecirclePushConfig
	 * @param rbLifecirclePushConfigDetailList
	 */
	public void saveMain(RbLifecirclePushConfig rbLifecirclePushConfig,List<RbLifecirclePushConfigDetail> rbLifecirclePushConfigDetailList) ;
	
	/**
	 * 修改一对多
	 *
   * @param rbLifecirclePushConfig
   * @param rbLifecirclePushConfigDetailList
	 */
	public void updateMain(RbLifecirclePushConfig rbLifecirclePushConfig,List<RbLifecirclePushConfigDetail> rbLifecirclePushConfigDetailList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
