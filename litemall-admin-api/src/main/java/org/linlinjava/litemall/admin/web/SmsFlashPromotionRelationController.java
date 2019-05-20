package org.linlinjava.litemall.admin.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionProduct;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionProductRelation;
import org.linlinjava.litemall.db.service.SmsFlashPromotionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/16 9:25
 * @Description:  限时购和商品关系管理
 */
@RestController
@RequestMapping("admin/smsFlashPromotionRelation")
@Validated
public class SmsFlashPromotionRelationController {
    @Autowired
    private SmsFlashPromotionRelationService service;

    /**
     * 批量选择商品添加关联
     */
    @RequiresPermissions("admin:flashPromotionRelation:create")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购和商品关系管理"}, button="添加")
    @PostMapping("/create")
    public Object create(@RequestBody List<SmsFlashPromotionProductRelation> relationList) {
        int count = service.create(relationList);
        if (count > 0) {
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    /**
     * 修改关联相关信息
     */
    @RequiresPermissions("admin:flashPromotionRelation:update")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购和商品关系管理"}, button="修改")
    @PostMapping("/update")
    public Object update(@PathVariable Long id, @RequestBody SmsFlashPromotionProductRelation relation) {
        int count = service.update(id, relation);
        if (count > 0) {
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    /**
     * 删除关联
     */
    @RequiresPermissions("admin:flashPromotionRelation:delete")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购和商品关系管理"}, button="删除")
    @PostMapping("/delete")
    public Object delete(@PathVariable Long id) {
        int count = service.delete(id);
        if (count > 0) {
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:flashPromotionRelation:getId")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购和商品关系管理"}, button="详情")
    @PostMapping("/getId")
    public Object getItem(@PathVariable Long id) {
        SmsFlashPromotionProductRelation relation = service.getId(id);
        return ResponseUtil.ok(relation);
    }

    @RequiresPermissions("admin:flashPromotionRelation:list")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购和商品关系管理"}, button="列表")
    @PostMapping("/list")
    public Object list(@RequestParam(value = "flashPromotionId", required = false) Long flashPromotionId,
                       @RequestParam(value = "flashPromotionSessionId", required = false) Long flashPromotionSessionId,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsFlashPromotionProduct> flashPromotionProductList = service.list(flashPromotionId, flashPromotionSessionId, pageSize, pageNum);
        return ResponseUtil.okList(flashPromotionProductList);
    }
}
