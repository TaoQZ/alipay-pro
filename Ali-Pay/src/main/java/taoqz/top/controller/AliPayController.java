package taoqz.top.controller;

import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taoqz.top.domain.AliBean;
import taoqz.top.service.PayService;

/**
 * @author HD
 * @version 1.0
 * @ClassName AliPayController
 * Description:
 * @date 2024/1/8/008 20:38
 */

@RestController
@RequestMapping("/pay")
public class AliPayController {
    @Autowired
    private PayService payService;

    @PostMapping(value = "alipay")
    public String alipay(@RequestBody AliBean alipayBean) throws AlipayApiException {
        return payService.aliPay(alipayBean);
    }

    @PostMapping(value = "alipayRefund")
    public Boolean alipayRefund(@RequestBody AliBean alipayBean) throws AlipayApiException {
        return payService.alipayRefund(alipayBean);
    }

}
