package org.jeecg.modules.demo.robot.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 圈子推送设置
 * @Author: jeecg-boot
 * @Date:   2022-09-11
 * @Version: V1.0
 */
@ApiModel(value="rb_lifecircle_push_config对象", description="圈子推送设置")
@Data
@TableName("rb_lifecircle_push_config")
public class RbLifecirclePushConfig implements Serializable {
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
	/**圈子ID*/
	@Excel(name = "圈子ID", width = 15)
    @ApiModelProperty(value = "圈子ID")
    private String lcId;
	/**圈子名称*/
	@Excel(name = "圈子名称", width = 15)
    @ApiModelProperty(value = "圈子名称")
    private String lcName;
	/**尾缀*/
	@Excel(name = "尾缀", width = 15)
    @ApiModelProperty(value = "尾缀")
    private String tail;
	/**推送*/
	@Excel(name = "推送", width = 15)
    @ApiModelProperty(value = "推送")
    private String needPush;
	/**统计*/
	@Excel(name = "统计", width = 15)
    @ApiModelProperty(value = "统计")
    private String needCount;
	/**类型*/
	@Excel(name = "类型", width = 15, dicCode = "lifecircle_type")
    @Dict(dicCode = "lifecircle_type")
    @ApiModelProperty(value = "类型")
    private String type;
	/**启用*/
	@Excel(name = "启用", width = 15)
    @ApiModelProperty(value = "启用")
    private String isActive;
	/**机器人编号*/
	@Excel(name = "机器人编号", width = 15, dictTable = "rb_robot", dicText = "name", dicCode = "code")
    @Dict(dictTable = "rb_robot", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "机器人编号")
    private String robotCode;
}
