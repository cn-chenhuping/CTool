package com.wechat.pay.java.service.transferbatch.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * chenhuping
 * 2023-06-09
 * 余额提现请求参数
 */
@Data
@Accessors(chain = true)
public class BalanceWithdrawal {

    /**
     * 提现类型
     */
    private Integer type;

    /**
     * 商家批次单号
     */
    private String outBatchNo;

    /**
     * 批次名称
     */
    private String batchName;

    /**
     * 批次备注
     */
    private String batchRemark;

    /**
     * 转账总金额-自动算
     */
    private BigDecimal totalAmount;

    /**
     * 转账总笔数-自动算
     */
    private Integer totalNum;

    /**
     * 转账明细列表
     */
    private List<TransferDetailInput> transferDetailList;

    /**
     * 转账场景ID-默认转账场景:1001 - 现金营销
     */
    private String transferSceneId = "1001";

    @Data
    public class transferDetail{
        /**
         * 商家明细单号，不填
         */
        private String out_detail_no;

        /**
         * 转账金额
         */
        private Long transfer_amount;

        /**
         * 转账备注
         */
        private String transfer_remark;

        /**
         * 用户在直连商户应用下的用户标示
         */
        private String openid;

        /**
         * 收款用户姓名-同一批次转账明细中，收款用户姓名字段需全部填写、或全部不填写
         */
        private String user_name;
    }

    /**
     * 计算转账总金额 单位 “分”
     * @return
     */
    public Long getTotalAmount() {
        Long totalAmount = 0L;
        List<TransferDetailInput> transferDetailList = this.transferDetailList;
        for (TransferDetailInput transferDetail : transferDetailList) {
            totalAmount += (transferDetail.getTransferAmount()*100);
        }
        return totalAmount;
    }

    /**
     * 计算转账总笔数
     * @return
     */
    public Integer getTotalNum() {
        return this.transferDetailList.size();
    }
}
