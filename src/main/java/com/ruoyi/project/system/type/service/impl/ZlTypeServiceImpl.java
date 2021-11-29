package com.ruoyi.project.system.type.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.type.mapper.ZlTypeMapper;
import com.ruoyi.project.system.type.domain.ZlType;
import com.ruoyi.project.system.type.service.IZlTypeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 资料类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
@Service
public class ZlTypeServiceImpl implements IZlTypeService 
{
    @Autowired
    private ZlTypeMapper zlTypeMapper;

    /**
     * 查询资料类型
     * 
     * @param id 资料类型主键
     * @return 资料类型
     */
    @Override
    public ZlType selectZlTypeById(Long id)
    {
        return zlTypeMapper.selectZlTypeById(id);
    }

    /**
     * 查询资料类型列表
     * 
     * @param zlType 资料类型
     * @return 资料类型
     */
    @Override
    public List<ZlType> selectZlTypeList(ZlType zlType)
    {
        return zlTypeMapper.selectZlTypeList(zlType);
    }

    /**
     * 新增资料类型
     * 
     * @param zlType 资料类型
     * @return 结果
     */
    @Override
    public int insertZlType(ZlType zlType)
    {
        return zlTypeMapper.insertZlType(zlType);
    }

    /**
     * 修改资料类型
     * 
     * @param zlType 资料类型
     * @return 结果
     */
    @Override
    public int updateZlType(ZlType zlType)
    {
        return zlTypeMapper.updateZlType(zlType);
    }

    /**
     * 批量删除资料类型
     * 
     * @param ids 需要删除的资料类型主键
     * @return 结果
     */
    @Override
    public int deleteZlTypeByIds(String ids)
    {
        return zlTypeMapper.deleteZlTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资料类型信息
     * 
     * @param id 资料类型主键
     * @return 结果
     */
    @Override
    public int deleteZlTypeById(Long id)
    {
        return zlTypeMapper.deleteZlTypeById(id);
    }
}
