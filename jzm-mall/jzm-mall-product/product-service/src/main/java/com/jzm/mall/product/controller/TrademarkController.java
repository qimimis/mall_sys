package com.jzm.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzm.mall.common.result.Result;
import com.jzm.mall.product.dto.TrademarkDTO;
import com.jzm.mall.product.dto.TrademarkPageDTO;
import com.jzm.mall.product.model.Trademark;
import com.jzm.mall.product.query.TrademarkParam;
import com.jzm.mall.product.service.TrademarkService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class TrademarkController {

    @Autowired
    private TrademarkService trademarkService;

    @Schema(title = "分页列表")
    @GetMapping("/baseTrademark/{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit) {
        // 创建分页参数对象
        Page<Trademark> pageParam = new Page<>(page, limit);
        // 调用服务获取分页数据
        TrademarkPageDTO trademarkPage = trademarkService.getPage(pageParam);
        // 返回统一格式的成功结果
        return Result.ok(trademarkPage);
    }

    @Schema(title = "获取Trademark")
    @GetMapping("/baseTrademark/get/{id}")
    public Result get(@PathVariable Long id) {
        // 调用服务获取单个品牌数据
        TrademarkDTO trademarkDTO = trademarkService.getTrademarkByTmId(id);
        return Result.ok(trademarkDTO);
    }

    @Schema(title = "新增Trademark")
    @PostMapping("/baseTrademark/save")
    public Result save(@RequestBody TrademarkParam banner) {
        // 调用服务保存品牌数据
        trademarkService.save(banner);
        return Result.ok();
    }

    @Schema(title = "修改Trademark")
    @PutMapping("/baseTrademark/update")
    public Result updateById(@RequestBody TrademarkParam banner) {
        // 调用服务更新品牌数据
        trademarkService.updateById(banner);
        return Result.ok();
    }

    @Schema(title = "删除Trademark")
    @DeleteMapping("/baseTrademark/remove/{id}")
    public Result remove(@PathVariable Long id) {
        // 调用服务删除品牌数据
        trademarkService.removeById(id);
        return Result.ok();
    }
}