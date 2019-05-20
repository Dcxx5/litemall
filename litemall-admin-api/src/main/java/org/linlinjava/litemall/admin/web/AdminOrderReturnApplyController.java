package org.linlinjava.litemall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.*;
import org.linlinjava.litemall.db.service.LitemallOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 15:46
 * @Description:订单退货申请管理
 */
@RestController
@RequestMapping("admin/orderReturnApply")
@Validated
public class AdminOrderReturnApplyController {
    private final Log log= LogFactory.getLog(AdminOrderReturnApplyController.class);
    @Autowired
    private LitemallOrderReturnApplyService service;

    @RequiresPermissions("admin:orderReturnApply:list")
    @RequiresPermissionsDesc(menu = {"商场管理", "退货申请"}, button = "查询")
    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       LitemallReturnApplyQueryParam queryParam) {
        List<LitemallOrderReturnApply> list=service.list(queryParam, page, limit);
        return ResponseUtil.okList(list);
    }
    @RequiresPermissions("admin:orderReturnApply:delete")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货申请"}, button="删除")
    @PostMapping("/delete")
    public Object delete(@RequestParam("ids") List<Long> ids){
        int count=service.delete(ids);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:orderReturnApply:read")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货申请"}, button="详情")
    @GetMapping("/read")
    public Object getItem(@PathVariable Long id){
        LitemallOrderReturnApplyResult returnApplyResult=service.getItem(id);
        return ResponseUtil.ok(returnApplyResult);
    }

    @RequiresPermissions("admin:orderReturnApply:update")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货申请"}, button="编辑")
    @PostMapping("/update")
    public Object updateStatus(@PathVariable Long id, @RequestBody LitemallUpdateStatusParam statusParam){
        int count=service.update(id, statusParam);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }
}
