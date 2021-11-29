package com.ruoyi.project.system.type.service;

import java.util.List;
import com.ruoyi.project.system.type.domain.ZlType;

/**
 * 资料类型Service接口
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
public interface IZlTypeService 
{
    /**
     * 查询资料类型
     * 
     * @param id 资料类型主键
     * @return 资料类型
     */
    public ZlType selectZlTypeById(Long id);

    /**
     * 查询资料类型列表
     * 
     * @param zlType 资料类型
     * @return 资料类型集合
     */
    public List<ZlType> selectZlTypeList(ZlType zlType);

    /**
     * 新增资料类型
     * 
     * @param zlType 资料类型
     * @return 结果
     */
    public int insertZlType(ZlType zlType);

    /**
     * 修改资料类型
     * 
     * @param zlType 资料类型
     * @return 结果
     */
    public int updateZlType(ZlType zlType);

    /**
     * 批量删除资料类型
     * 
     * @param ids 需要删除的资料类型主键集合
     * @return 结果
     */
    public int deleteZlTypeByIds(String ids);

    /**
     * 删除资料类型信息
     * 
     * @param id 资料类型主键
     * @return 结果
     */
    public int deleteZlTypeById(Long id);
}
