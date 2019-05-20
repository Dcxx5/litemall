package org.linlinjava.litemall.db.domain;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 19:39
 * @Description:
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {

    private LitemallGoods product;

    public LitemallGoods getProduct() {
        return product;
    }

    public void setProduct(LitemallGoods product) {
        this.product = product;
    }
}
