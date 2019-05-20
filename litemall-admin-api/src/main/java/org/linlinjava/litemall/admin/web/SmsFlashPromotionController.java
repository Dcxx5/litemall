package org.linlinjava.litemall.admin.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.SmsFlashPromotion;
import org.linlinjava.litemall.db.service.SmsFlashPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 17:38
 * @Description:限时购活动管理
 */
@RestController
@RequestMapping("sms/flash")
@Validated
public class SmsFlashPromotionController {
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;

    @RequiresPermissions("admin:smsFlashPromotion:create")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="添加")
    @PostMapping("/create")
    public Object create(@RequestBody SmsFlashPromotion smsFlashPromotion){
        int count=smsFlashPromotionService.create(smsFlashPromotion);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:smsFlashPromotion:delete")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="删除")
    @PostMapping("/delete")
    public Object delete(@PathVariable Long id){
        int count=smsFlashPromotionService.delete(id);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }
    @RequiresPermissions("admin:smsFlashPromotion:updateStatus")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="修改状态")
    @PostMapping("/updateStatus")
    public Object updateStatus(@PathVariable Long id,Integer status){
        int count=smsFlashPromotionService.updateStatus(id, status);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:smsFlashPromotion:getId")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="详情")
    @PostMapping("/getId")
    public Object getId(@PathVariable Long id){
        SmsFlashPromotion smsFlashPromotion=smsFlashPromotionService.getId(id);
        return ResponseUtil.ok(smsFlashPromotion);
    }

    @RequiresPermissions("admin:smsFlashPromotion:list")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="列表")
    @PostMapping("/list")
    public Object list(@RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<SmsFlashPromotion> list=smsFlashPromotionService.list(keyword, pageSize, pageNum);
        return ResponseUtil.okList(list);
    }

    @RequiresPermissions("admin:smsFlashPromotion:update")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购活动管理"}, button="修改")
    @PostMapping("/update")
    public Object update(@PathVariable Long id, @RequestBody SmsFlashPromotion smsFlashPromotion){
        int count=smsFlashPromotionService.update(id, smsFlashPromotion);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }
}
