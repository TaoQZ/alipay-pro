package taoqz.top.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import taoqz.top.config.AliPayProperties;
import taoqz.top.domain.AliBean;

/**
 * @author HD
 * @version 1.0
 * @ClassName AliPay
 * Description:
 * @date 2024/1/8/008 20:43
 */
@Component
public class AliPay {


    @Autowired
    private AliPayProperties aliPayProperties;

    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    public String pay(AliBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        String serverUrl = aliPayProperties.getGatwayurl();
        String appId = aliPayProperties.getAppid();
        String privateKey = aliPayProperties.getPrivatekey();
        String format = "json";
        String charset = aliPayProperties.getCharset();
        String alipayPublicKey = aliPayProperties.getPublickey();
        String signType = aliPayProperties.getSigntype();
        String returnUrl = aliPayProperties.getReturnurl();
        String notifyUrl = aliPayProperties.getNotitfyurl();
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(result);
        // 返回付款信息
        return result;
    }

    public Boolean alipayRefund(AliBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        String serverUrl = aliPayProperties.getGatwayurl();
        String appId = aliPayProperties.getAppid();
        String privateKey = aliPayProperties.getPrivatekey();
        String format = "json";
        String charset = aliPayProperties.getCharset();
        String alipayPublicKey = aliPayProperties.getPublickey();
        String signType = aliPayProperties.getSigntype();
        String returnUrl = aliPayProperties.getReturnurl();
        String notifyUrl = aliPayProperties.getNotitfyurl();
        String aliPublicKey = aliPayProperties.getAliPublicKey();
//        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, aliPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        AlipayTradeRefundRequest alipayTradeCloseRequest =new AlipayTradeRefundRequest();
        //请求参数集合对象,除了公共参数之外,所有参数都可通过此对象传递
        AlipayTradeRefundModel alipayTradeRefundModel =new AlipayTradeRefundModel();
        //退款的订单号,传入生成支付订单时的订单号即可
        alipayTradeRefundModel.setOutTradeNo(alipayBean.getOut_trade_no());
        //退款金额
        alipayTradeRefundModel.setRefundAmount(alipayBean.getTotal_amount());
        //退款的原因
        alipayTradeRefundModel.setRefundReason(alipayBean.getBody());
        alipayTradeCloseRequest.setBizModel(alipayTradeRefundModel);

        // 3、请求支付宝进行退款，并获取退款结果
        AlipayTradeRefundResponse response = alipayClient.execute(alipayTradeCloseRequest);
        System.out.println(response);
        // 返回付款信息
        return response.isSuccess() && response.getFundChange().equals("Y");
    }
}
