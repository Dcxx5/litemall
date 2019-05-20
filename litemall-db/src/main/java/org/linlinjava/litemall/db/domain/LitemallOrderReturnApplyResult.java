package org.linlinjava.litemall.db.domain;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 15:15
 * @Description:
 */
public class LitemallOrderReturnApplyResult extends LitemallOrderReturnApply {

    private LitemallAddress address;

    public LitemallAddress getAddress() {
        return address;
    }

    public void setAddress(LitemallAddress address) {
        this.address = address;
    }
}
