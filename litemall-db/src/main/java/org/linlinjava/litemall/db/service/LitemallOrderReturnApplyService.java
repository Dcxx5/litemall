package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallOrderReturnApplyMapper;
import org.linlinjava.litemall.db.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 15:08
 * @Description:退货申请管理
 */
@Service
public class LitemallOrderReturnApplyService {
    @Resource
    private LitemallOrderReturnApplyMapper mapper;

    public List<LitemallOrderReturnApply> list(LitemallReturnApplyQueryParam queryParam,Integer pageSize,Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        return mapper.getList(queryParam);
    }

    public int delete(List<Long> ids){
        LitemallOrderReturnApplyExample example=new LitemallOrderReturnApplyExample();
        example.createCriteria().andIdIn(ids);
        return mapper.deleteByExample(example);
    }

    public int update(Long id, LitemallUpdateStatusParam statusParam){
        Integer status=statusParam.getStatus();
        LitemallOrderReturnApply returnApply=new LitemallOrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        } else if (status.equals(2)) {
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        } else if (status.equals(3)) {
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        } else {
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(returnApply);
    }

    public LitemallOrderReturnApplyResult getItem(Long id){
        return mapper.getDetail(id);
    }
}
