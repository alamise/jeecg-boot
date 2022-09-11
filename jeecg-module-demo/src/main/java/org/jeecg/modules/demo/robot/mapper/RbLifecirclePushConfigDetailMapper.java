package org.jeecg.modules.demo.robot.mapper;

import java.util.List;
import org.jeecg.modules.demo.robot.entity.RbLifecirclePushConfigDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 圈子推送配置明细
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
public interface RbLifecirclePushConfigDetailMapper extends BaseMapper<RbLifecirclePushConfigDetail> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<RbLifecirclePushConfigDetail>
   */
	public List<RbLifecirclePushConfigDetail> selectByMainId(@Param("mainId") String mainId);
}
