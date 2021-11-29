package com.ruoyi.project.system.details.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 资料详情信息对象 zl_details
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
public class ZlDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 类型id */
    @Excel(name = "类型id")
    private Long lxId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String lxName;

    /** 资料标题 */
    @Excel(name = "资料标题")
    private String title;

    /** 资料链接 */
    @Excel(name = "资料链接")
    private String zlUrl;

    /** 资料描述 */
    @Excel(name = "资料描述")
    private String zlDesc;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLxId(Long lxId)
    {
        this.lxId = lxId;
    }

    public Long getLxId()
    {
        return lxId;
    }
    public void setLxName(String lxName)
    {
        this.lxName = lxName;
    }

    public String getLxName()
    {
        return lxName;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setZlUrl(String zlUrl)
    {
        this.zlUrl = zlUrl;
    }

    public String getZlUrl()
    {
        return zlUrl;
    }
    public void setZlDesc(String zlDesc)
    {
        this.zlDesc = zlDesc;
    }

    public String getZlDesc()
    {
        return zlDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lxId", getLxId())
            .append("lxName", getLxName())
            .append("title", getTitle())
            .append("zlUrl", getZlUrl())
            .append("zlDesc", getZlDesc())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
