package org.linlinjava.litemall.db.domain;

import java.math.BigDecimal;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 15:32
 * @Description:确认收货提交参数
 */
public class LitemallUpdateStatusParam {
    private Long id;//服务单号

    private Long companyAddressId;//收货地址关联id

    private BigDecimal returnAmount;//确认退款金额

    private String handleNote;//处理备注

    private String handleMan;//处理人

    private String receiveNote;//收货备注

    private String receiveMan;//收货人

    private Integer status;//申请状态：1->退货中；2->已完成；3->已拒绝

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
