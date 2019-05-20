package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallOrderReturnReasonMapper;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnReason;
import org.linlinjava.litemall.db.domain.LitemallOrderReturnReasonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/14 17:43
 * @Description:
 */
@Service
public class LitemallOrderReturnReasonService {

    @Resource
    private LitemallOrderReturnReasonMapper mapper;

    /**
     * 添加退货原因
     * @param litemallOrderReturnReason
     * @return
     */
    public int create(LitemallOrderReturnReason litemallOrderReturnReason){
        litemallOrderReturnReason.setCreateTime(new Date());
        return mapper.insert(litemallOrderReturnReason);
    }

    public int update(Long id,LitemallOrderReturnReason litemallOrderReturnReason){
        litemallOrderReturnReason.setId(id);
        return mapper.updateByPrimaryKey(litemallOrderReturnReason);
    }

    public int delete(List<Long> ids){
        LitemallOrderReturnReasonExample example=new LitemallOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return mapper.deleteByExample(example);
    }

    public List<LitemallOrderReturnReason> list(Integer pageSize, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        LitemallOrderReturnReasonExample example=new LitemallOrderReturnReasonExample();
        example.setOrderByClause("sort desc");
        return mapper.selectByExample(example);
    }

    public int updateStatus(List<Long> ids, Integer status){
        if(!status.equals("0") && !status.equals(1)){
            return 0;
        }
        LitemallOrderReturnReason reason=new LitemallOrderReturnReason();
        reason.setStatus(status);
        LitemallOrderReturnReasonExample example=new LitemallOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return mapper.updateByExampleSelective(reason, example);
    }

    public LitemallOrderReturnReason getId(Long id){
        return mapper.selectByPrimaryKey(id);
    }
}
