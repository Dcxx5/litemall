package org.linlinjava.litemall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnApplyResult;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnReason;
import org.linlinjava.litemall.db.service.LitemallOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/14 17:59
 * @Description:退货原因
 */
@RestController
@RequestMapping("/admin/orderReturnReason")
@Validated
public class AdminOrderReturnReasonController {
    private final Log log= LogFactory.getLog(AdminOrderReturnReasonController.class);

    @Autowired
    private LitemallOrderReturnReasonService service;

    @RequiresPermissions("admin:orderReturnReason:list")
    @RequiresPermissionsDesc(menu = {"商场管理", "退货原因管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        List<LitemallOrderReturnReason> list=service.list(page, limit);
        return ResponseUtil.okList(list);
    }
    @RequiresPermissions("admin:orderReturnReason:create")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货原因管理"}, button="添加")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallOrderReturnReason ad) {
        int count=service.create(ad);
        if(count>0){
            return ResponseUtil.ok(ad);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:orderReturnReason:read")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货原因管理"}, button="详情")
    @GetMapping("/read")
    public Object read(@NotNull Integer id) {
        LitemallOrderReturnReason ad = service.getId(id.longValue());
        return ResponseUtil.ok(ad);
    }

    @RequiresPermissions("admin:orderReturnReason:update")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货原因管理"}, button="编辑")
    @PostMapping("/update")
    public Object update(@PathVariable Long id,@RequestBody LitemallOrderReturnReason ad) {
        int count=service.update(id, ad);
        if(count>0){
            return ResponseUtil.ok(ad);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:orderReturnReason:delete")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货原因管理"}, button="删除")
    @PostMapping("/delete")
    public Object delete(@RequestParam("ids") List<Long> ids) {
        int count=service.delete(ids);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }

    @RequiresPermissions("admin:orderReturnReason:updateStatus")
    @RequiresPermissionsDesc(menu={"商场管理" , "退货原因管理"}, button="启用状态")
    @PostMapping("/updateStatus")
    public Object updateStatus(@RequestParam(value = "status") Integer status,
                               @RequestParam("ids") List<Long> ids) {
        int count=service.updateStatus(ids, status);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }
}
