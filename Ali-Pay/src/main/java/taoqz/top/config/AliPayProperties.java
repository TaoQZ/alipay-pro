package taoqz.top.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName AliPayProperties
 * Description:
 */
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class AliPayProperties {
    //应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    private String appid;
    //商户私钥，您的PKCS8格式RSA2私钥
    private String privatekey;
    //支付宝公钥,查看地址：https://openhome.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private String publickey;
    //服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
    private String notitfyurl;
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
    private String returnurl;
    // 签名方式
    private String signtype;
    //字符编码格式
    private String charset;
    //支付宝网关
    private String gatwayurl;
    //支付宝日志
    private String lohpsyh = "D:\\";
    private String aliPublicKey;

    public AliPayProperties() {
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getNotitfyurl() {
        return notitfyurl;
    }

    public void setNotitfyurl(String notitfyurl) {
        this.notitfyurl = notitfyurl;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatwayurl() {
        return gatwayurl;
    }

    public void setGatwayurl(String gatwayurl) {
        this.gatwayurl = gatwayurl;
    }

    public String getLohpsyh() {
        return lohpsyh;
    }

    public void setLohpsyh(String lohpsyh) {
        this.lohpsyh = lohpsyh;
    }

    public String getAliPublicKey() {
        return aliPublicKey;
    }

    public void setAliPublicKey(String aliPublicKey) {
        this.aliPublicKey = aliPublicKey;
    }
}
