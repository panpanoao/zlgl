package com.ruoyi.project.system.details.service;

import java.util.List;
import com.ruoyi.project.system.details.domain.ZlDetails;

/**
 * 资料详情信息Service接口
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
public interface IZlDetailsService 
{
    /**
     * 查询资料详情信息
     * 
     * @param id 资料详情信息主键
     * @return 资料详情信息
     */
    public ZlDetails selectZlDetailsById(Long id);

    /**
     * 查询资料详情信息列表
     * 
     * @param zlDetails 资料详情信息
     * @return 资料详情信息集合
     */
    public List<ZlDetails> selectZlDetailsList(ZlDetails zlDetails);

    /**
     * 新增资料详情信息
     * 
     * @param zlDetails 资料详情信息
     * @return 结果
     */
    public int insertZlDetails(ZlDetails zlDetails);

    /**
     * 修改资料详情信息
     * 
     * @param zlDetails 资料详情信息
     * @return 结果
     */
    public int updateZlDetails(ZlDetails zlDetails);

    /**
     * 批量删除资料详情信息
     * 
     * @param ids 需要删除的资料详情信息主键集合
     * @return 结果
     */
    public int deleteZlDetailsByIds(String ids);

    /**
     * 删除资料详情信息信息
     * 
     * @param id 资料详情信息主键
     * @return 结果
     */
    public int deleteZlDetailsById(Long id);
}
