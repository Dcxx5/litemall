package org.linlinjava.litemall.admin.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSession;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSessionDetail;
import org.linlinjava.litemall.db.service.SmsFlashPromotionSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 20:01
 * @Description: 限时购场次管理Controller
 */
@RestController
@RequestMapping("admin/flashSession")
@Validated
public class SmsFlashPromotionSessionController {

    @Autowired
    private SmsFlashPromotionSessionService flashPromotionSessionService;

    @RequiresPermissions("admin:flashSession:create")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="添加")
    @PostMapping("/create")
    public Object create(@RequestBody SmsFlashPromotionSession promotionSession) {
        int count = flashPromotionSessionService.create(promotionSession);
        if (count > 0) {
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:flashSession:update")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="修改")
    @PostMapping("/update")
    public Object update(@PathVariable Long id, @RequestBody SmsFlashPromotionSession promotionSession){
        int count=flashPromotionSessionService.update(id, promotionSession);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:flashSession:updateStatus")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="修改状态")
    @PostMapping("/updateStatus")
    public Object updateStatus(@PathVariable Long id, Integer status){
        int count=flashPromotionSessionService.updateStatus(id, status);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:flashSession:delete")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="删除")
    @PostMapping("/delete")
    public Object delete(@PathVariable Long id){
        int count=flashPromotionSessionService.delete(id);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:flashSession:getId")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="详情")
    @PostMapping("/getId")
    public Object getId(@PathVariable Long id){
        SmsFlashPromotionSession smsFlashPromotionSession=flashPromotionSessionService.getItem(id);
        return ResponseUtil.ok(smsFlashPromotionSession);
    }

    @RequiresPermissions("admin:flashSession:list")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="列表")
    @PostMapping("/list")
    public Object list(){
        List<SmsFlashPromotionSession> list=flashPromotionSessionService.list();
        return ResponseUtil.okList(list);
    }

    /*
     获取全部可选场次及其数量
     */
    @RequiresPermissions("admin:flashSession:selectList")
    @RequiresPermissionsDesc(menu={"商场管理" , "限时购场次管理"}, button="可选场次")
    @PostMapping("/selectList")
    public Object selectList(Long flashPromotionId){
        List<SmsFlashPromotionSessionDetail> list=flashPromotionSessionService.selectList(flashPromotionId);
        return ResponseUtil.okList(list);
    }
}
