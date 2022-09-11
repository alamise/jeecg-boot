package org.jeecg.modules.demo.robot.service;

import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 圈子推送配置明细
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
public interface IRbLifecirclePushConfigDetailService extends IService<RbLifecirclePushConfigDetail> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<RbLifecirclePushConfigDetail>
	 */
	public List<RbLifecirclePushConfigDetail> selectByMainId(String mainId);
}
