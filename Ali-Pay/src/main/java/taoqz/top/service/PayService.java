package taoqz.top.service;

import com.alipay.api.AlipayApiException;
import taoqz.top.domain.AliBean;

/**
 * @author HD
 * @version 1.0
 * @ClassName PayService
 * Description:
 * @date 2024/1/8/008 20:40
 */
public interface PayService {
    String aliPay(AliBean alipayBean) throws AlipayApiException;

    Boolean alipayRefund(AliBean alipayBean) throws AlipayApiException;
}
