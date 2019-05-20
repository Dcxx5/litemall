package org.linlinjava.litemall.wx.web;

import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnApplyParam;
import org.linlinjava.litemall.wx.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/16 9:44
 * @Description: 申请退货管理Controller
 */
@RestController
@RequestMapping("wx/orderReturnApply")
@Validated
public class OrderReturnApplyController {

    @Autowired
    private OrderReturnApplyService service;

    @PostMapping("create")
    public Object create(@RequestBody LitemallOrderReturnApplyParam returnApply){
        int count=service.create(returnApply);
        if(count>0){
            return ResponseUtil.ok(count);
        }
        return ResponseUtil.fail();
    }
}



