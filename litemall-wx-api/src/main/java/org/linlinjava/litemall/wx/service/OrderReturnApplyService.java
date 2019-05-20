package org.linlinjava.litemall.wx.service;

import org.linlinjava.litemall.db.dao.LitemallOrderReturnApplyMapper;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnApply;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnApplyParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/16 9:41
 * @Description:  订单退货管理Service实现类
 */
@Service
public class OrderReturnApplyService {
    @Resource
    private LitemallOrderReturnApplyMapper mapper;

    public int create(LitemallOrderReturnApplyParam returnApply) {
        LitemallOrderReturnApply realApply = new LitemallOrderReturnApply();
        BeanUtils.copyProperties(returnApply, realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);
        return mapper.insert(realApply);
    }
}
