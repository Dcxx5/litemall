package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.SmsFlashPromotionSessionMapper;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSession;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSessionDetail;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSessionExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 19:55
 * @Description: 限时购场次管理Service实现类
 */
@Service
public class SmsFlashPromotionSessionService {
    @Resource
    private SmsFlashPromotionSessionMapper mapper;
    @Autowired
    private SmsFlashPromotionRelationService relationService;

    public int create(SmsFlashPromotionSession promotionSession) {
        promotionSession.setCreateTime(new Date());
        return mapper.insert(promotionSession);
    }

    public int update(Long id, SmsFlashPromotionSession promotionSession) {
        promotionSession.setId(id);
        return mapper.updateByPrimaryKey(promotionSession);
    }

    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotionSession promotionSession = new SmsFlashPromotionSession();
        promotionSession.setId(id);
        promotionSession.setStatus(status);
        return mapper.updateByPrimaryKeySelective(promotionSession);
    }

    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public SmsFlashPromotionSession getItem(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<SmsFlashPromotionSession> list() {
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        return mapper.selectByExample(example);
    }

    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<SmsFlashPromotionSessionDetail> result = new ArrayList<>();
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<SmsFlashPromotionSession> list = mapper.selectByExample(example);
        for (SmsFlashPromotionSession promotionSession : list) {
            SmsFlashPromotionSessionDetail detail = new SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            int count = relationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return result;
    }
}
