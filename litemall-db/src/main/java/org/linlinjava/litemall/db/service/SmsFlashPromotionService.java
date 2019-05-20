package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.SmsFlashPromotionMapper;
import org.linlinjava.litemall.db.domain.SmsFlashPromotion;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 17:23
 * @Description:限时购活动管理Service实现类
 */
@Service
public class SmsFlashPromotionService {
    @Resource
    private SmsFlashPromotionMapper mapper;

    public int create(SmsFlashPromotion flashPromotion){
        flashPromotion.setCreateTime(new Date());
        return mapper.insert(flashPromotion);
    }

    public int update (Long id,SmsFlashPromotion flashPromotion){
        flashPromotion.setId(id);
        return mapper.updateByPrimaryKey(flashPromotion);
    }

    public int delete(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int updateStatus(Long id,Integer status){
        SmsFlashPromotion smsFlashPromotion=new SmsFlashPromotion();
        smsFlashPromotion.setId(id);
        smsFlashPromotion.setStatus(status);
        return mapper.updateByPrimaryKeySelective(smsFlashPromotion);
    }

    public SmsFlashPromotion getId(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<SmsFlashPromotion> list(String keyword,Integer pagesize,Integer pageNum){
        PageHelper.startPage(pageNum, pagesize);
        SmsFlashPromotionExample example=new SmsFlashPromotionExample();
        if(!StringUtils.isEmpty(keyword)){
            example.createCriteria().andTitleLike("%"+keyword+"%");
        }
        return mapper.selectByExample(example);
    }
}
