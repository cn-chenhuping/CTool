package com.wechat.pay.java.service.payments.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询订单请求参数(正常XML)
 * @author chenhuping
 * @date  2023-06-09
 *
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Data
public class WxOrderQueryParams implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 微信订单号,优先
     */
    private String transaction_id;

    /**
     * 商户订单号 二选一
     */
    private String out_trade_no;

    /**
     * 商户号
     */
    private String mch_id;
}
