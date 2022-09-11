package org.jeecg.modules.demo.robot.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 圈子推送配置明细
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
@ApiModel(value="rb_lifecircle_push_config_detail对象", description="圈子推送配置明细")
@Data
@TableName("rb_lifecircle_push_config_detail")
public class RbLifecirclePushConfigDetail implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**圈子配置ID*/
    @ApiModelProperty(value = "圈子配置ID")
    private String lcConfigId;
	/**群名称*/
	@Excel(name = "群名称", width = 15)
    @ApiModelProperty(value = "群名称")
    private String groupName;
	/**是否统计*/
	@Excel(name = "是否统计", width = 15)
    @ApiModelProperty(value = "是否统计")
    private String needCount;
}
