package com.ruoyi.project.system.details.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.details.mapper.ZlDetailsMapper;
import com.ruoyi.project.system.details.domain.ZlDetails;
import com.ruoyi.project.system.details.service.IZlDetailsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 资料详情信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
@Service
public class ZlDetailsServiceImpl implements IZlDetailsService 
{
    @Autowired
    private ZlDetailsMapper zlDetailsMapper;

    /**
     * 查询资料详情信息
     * 
     * @param id 资料详情信息主键
     * @return 资料详情信息
     */
    @Override
    public ZlDetails selectZlDetailsById(Long id)
    {
        return zlDetailsMapper.selectZlDetailsById(id);
    }

    /**
     * 查询资料详情信息列表
     * 
     * @param zlDetails 资料详情信息
     * @return 资料详情信息
     */
    @Override
    public List<ZlDetails> selectZlDetailsList(ZlDetails zlDetails)
    {
        return zlDetailsMapper.selectZlDetailsList(zlDetails);
    }

    /**
     * 新增资料详情信息
     * 
     * @param zlDetails 资料详情信息
     * @return 结果
     */
    @Override
    public int insertZlDetails(ZlDetails zlDetails)
    {
        zlDetails.setCreateTime(DateUtils.getNowDate());
        return zlDetailsMapper.insertZlDetails(zlDetails);
    }

    /**
     * 修改资料详情信息
     * 
     * @param zlDetails 资料详情信息
     * @return 结果
     */
    @Override
    public int updateZlDetails(ZlDetails zlDetails)
    {
        zlDetails.setUpdateTime(DateUtils.getNowDate());
        return zlDetailsMapper.updateZlDetails(zlDetails);
    }

    /**
     * 批量删除资料详情信息
     * 
     * @param ids 需要删除的资料详情信息主键
     * @return 结果
     */
    @Override
    public int deleteZlDetailsByIds(String ids)
    {
        return zlDetailsMapper.deleteZlDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资料详情信息信息
     * 
     * @param id 资料详情信息主键
     * @return 结果
     */
    @Override
    public int deleteZlDetailsById(Long id)
    {
        return zlDetailsMapper.deleteZlDetailsById(id);
    }
}
