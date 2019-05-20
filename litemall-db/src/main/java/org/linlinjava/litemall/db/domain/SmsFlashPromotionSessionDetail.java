package org.linlinjava.litemall.db.domain;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 19:57
 * @Description:
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {

    private Integer productCount;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}

