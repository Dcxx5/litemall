package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.SmsFlashPromotionProductRelationMapper;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionProduct;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionProductRelation;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionProductRelationExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 19:31
 * @Description: 限时购商品关联管理Service实现类
 */
@Service
public class SmsFlashPromotionRelationService {
    @Resource
    private SmsFlashPromotionProductRelationMapper mapper;

    public int create(List<SmsFlashPromotionProductRelation> list){
        for(SmsFlashPromotionProductRelation relation:list){
            mapper.insert(relation);
        }
        return list.size();
    }

    public int update(Long id,SmsFlashPromotionProductRelation relation){
        relation.setId(id);
        return mapper.updateByPrimaryKey(relation);
    }

    public int delete(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    public SmsFlashPromotionProductRelation getId(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        return mapper.getList(flashPromotionId, flashPromotionSessionId);
    }

    public int getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        SmsFlashPromotionProductRelationExample example = new SmsFlashPromotionProductRelationExample();
        example.createCriteria()
                .andFlashPromotionIdEqualTo(flashPromotionId)
                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        return mapper.countByExample(example);
    }
}
