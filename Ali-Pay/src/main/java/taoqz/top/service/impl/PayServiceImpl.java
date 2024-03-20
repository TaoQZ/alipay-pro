package taoqz.top.service.impl;

import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taoqz.top.domain.AliBean;
import taoqz.top.pay.AliPay;
import taoqz.top.service.PayService;

/**
 * @author HD
 * @version 1.0
 * @ClassName PayServiceImpl
 * Description:
 * @date 2024/1/8/008 20:41
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private AliPay aliPay;

    @Override
    public String aliPay(AliBean alipayBean) throws AlipayApiException {
        return aliPay.pay(alipayBean);
    }

    @Override
    public Boolean alipayRefund(AliBean alipayBean) throws AlipayApiException {
        return aliPay.alipayRefund(alipayBean);
    }
}
