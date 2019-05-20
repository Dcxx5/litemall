package org.linlinjava.litemall.db.domain;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/15 15:02
 * @Description:订单退货申请查询参数
 */

public class LitemallReturnApplyQueryParam {
    private Long id; //服务单号

    private String receiverKeyword;//收货人姓名/号码

    private Integer status;//申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝

    private String createTime;//申请时间

    private String handleMan;//处理人员

    private String handleTime;//处理时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverKeyword() {
        return receiverKeyword;
    }

    public void setReceiverKeyword(String receiverKeyword) {
        this.receiverKeyword = receiverKeyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }
}

