package com.ruoyi.project.system.type.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.type.domain.ZlType;
import com.ruoyi.project.system.type.service.IZlTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 资料类型Controller
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
@Controller
@RequestMapping("/system/type")
public class ZlTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IZlTypeService zlTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询资料类型列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZlType zlType)
    {
        startPage();
        List<ZlType> list = zlTypeService.selectZlTypeList(zlType);
        return getDataTable(list);
    }

    @RequiresPermissions("system:type:list")
    @GetMapping("/getSelect")
    @ResponseBody
    public AjaxResult getSelect(){
        return AjaxResult.success(zlTypeService.selectZlTypeList(null));
    }

    /**
     * 导出资料类型列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "资料类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZlType zlType)
    {
        List<ZlType> list = zlTypeService.selectZlTypeList(zlType);
        ExcelUtil<ZlType> util = new ExcelUtil<ZlType>(ZlType.class);
        return util.exportExcel(list, "资料类型数据");
    }

    /**
     * 新增资料类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资料类型
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "资料类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZlType zlType)
    {
        return toAjax(zlTypeService.insertZlType(zlType));
    }

    /**
     * 修改资料类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ZlType zlType = zlTypeService.selectZlTypeById(id);
        mmap.put("zlType", zlType);
        return prefix + "/edit";
    }

    /**
     * 修改保存资料类型
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "资料类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZlType zlType)
    {
        return toAjax(zlTypeService.updateZlType(zlType));
    }

    /**
     * 删除资料类型
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "资料类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zlTypeService.deleteZlTypeByIds(ids));
    }
}
