package com.ruoyi.project.system.details.controller;

import java.util.List;
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
import com.ruoyi.project.system.details.domain.ZlDetails;
import com.ruoyi.project.system.details.service.IZlDetailsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 资料详情信息Controller
 * 
 * @author ruoyi
 * @date 2021-11-29
 */
@Controller
@RequestMapping("/system/details")
public class ZlDetailsController extends BaseController
{
    private String prefix = "system/details";

    @Autowired
    private IZlDetailsService zlDetailsService;

    @RequiresPermissions("system:details:view")
    @GetMapping()
    public String details()
    {
        return prefix + "/details";
    }

    /**
     * 查询资料详情信息列表
     */
    @RequiresPermissions("system:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZlDetails zlDetails)
    {
        startPage();
        List<ZlDetails> list = zlDetailsService.selectZlDetailsList(zlDetails);
        return getDataTable(list);
    }




    /**
     * 导出资料详情信息列表
     */
    @RequiresPermissions("system:details:export")
    @Log(title = "资料详情信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZlDetails zlDetails)
    {
        List<ZlDetails> list = zlDetailsService.selectZlDetailsList(zlDetails);
        ExcelUtil<ZlDetails> util = new ExcelUtil<ZlDetails>(ZlDetails.class);
        return util.exportExcel(list, "资料详情信息数据");
    }

    /**
     * 新增资料详情信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资料详情信息
     */
    @RequiresPermissions("system:details:add")
    @Log(title = "资料详情信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZlDetails zlDetails)
    {
        return toAjax(zlDetailsService.insertZlDetails(zlDetails));
    }

    /**
     * 修改资料详情信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ZlDetails zlDetails = zlDetailsService.selectZlDetailsById(id);
        mmap.put("zlDetails", zlDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存资料详情信息
     */
    @RequiresPermissions("system:details:edit")
    @Log(title = "资料详情信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZlDetails zlDetails)
    {
        return toAjax(zlDetailsService.updateZlDetails(zlDetails));
    }

    /**
     * 删除资料详情信息
     */
    @RequiresPermissions("system:details:remove")
    @Log(title = "资料详情信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zlDetailsService.deleteZlDetailsByIds(ids));
    }
}
