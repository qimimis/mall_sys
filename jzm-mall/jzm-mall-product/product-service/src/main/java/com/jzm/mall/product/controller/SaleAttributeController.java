package com.jzm.mall.product.controller;

import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.SaleAttributeInfoDTO;
import com.jzm.mall.product.service.SalesAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售属性控制器
 * 处理销售属性相关的HTTP请求
 */
@RestController
@RequestMapping("admin/product")
public class SaleAttributeController {

    /**
     * 销售属性服务
     */
    @Autowired
    private SalesAttributeService salesAttributeService;

    /**
     * 获取所有基础销售属性列表
     *
     * @return 包含销售属性列表的结果对象
     */
    @GetMapping("baseSaleAttrList")
    public Result SaleAttrList() {
        // 查询所有的销售属性集合
        List<SaleAttributeInfoDTO> saleAttrInfoList = salesAttributeService.getSaleAttrInfoList();
        // 返回成功结果及数据
        return Result.ok(saleAttrInfoList);
    }
}