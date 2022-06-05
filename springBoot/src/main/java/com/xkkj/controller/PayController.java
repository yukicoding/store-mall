package com.xkkj.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.xkkj.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class PayController {
//    @Autowired
//    DonaItemService donaItemService;
//    @Autowired
//    DonaService donaService;
    //appid
    private final String APP_ID = "2021000120609082";
    //应用私钥
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCnP+XJiNwwFOh/XNnYWDhsCfe2qNzQTErjTXysFsq8KIpTbJm/t9gf5DWZjBto2CGDQwBFHctrBeIu4NcrDPkB+Lfh5/XPkhrLHg49du1VIGz7YobNoK78i/0GzRDyoiIXPjkHaLiCEThOBJTdUkyd5lHP3sBfGAQt+ty1bkx9LDPDYTHU3tkUv4+zBxqM/ipRGOvlk+a/0bn4ugVU9ApKiASk+nfV10noL31YjPDuxyDD3qNYYpFXqi2C39CFitEzgCGjS1LQkIJmoyvfUc1moAtoHipNOSPvyzALQgai21+wGMZuCMYBGf/Yo4hpI1CRmcBnH0BbziolPAfjZZd/AgMBAAECggEAHUGIKKDQI3kE0oKjeLy14fA8bK9NMQKndutvC4tRG2jcCYvNuUOngqyg06M2iDiGZDesLGrx0l7NGfYqrVUvmbCwOcwhq5WbKjyvsQDEs0dgyPiLLB0XfwXd1Pq6JDdIT1iLEUi4PchVWRBkGfLzhAtt9Da63+eLk592TCZnKt3wDYymyjG/30xV8q8fziDm0HvodMLRCZZDXHUSnQZFwfmsO6DMG3R9Exc3AqTj6HLcr0QoFzcYTQYWAdc/d0AeK8jCVPQymRzeHBM+KEbuu03Bk8rGAxDOjdr1XxW1nuEkDp0SB1pFLSuRD54kWM6DKVbRH/uHSy6Bx18YoIa/gQKBgQDbFkyn/PLm2j5bTsG+CSMIS0OMoe08i7sZPFEagcQXvh/LS0Im0diaOK/tY/k5ezC8w7DwTjhx2iGGqJ2FhfF8KLe0dpxCmt1vtyjzgKopcgQWzbiMIz7oVycYC5n0xXddfr2p290RIwf17Usvptf0hXcSLcvbPiXn4Yz3c+napwKBgQDDbbwC/chZdm+UhnUu183NfgBnpUwj8RyXYrhBx2B6IqlKj48OG2Jb6O00RLO6AxFc/Gh9A2TojdOdkIoUXcE6VjIMZj2iC40J6SZioVrYP7gSlMMCbshatee6hWTLMnQzJbf+R+/CR0bHZE5uwYQUl50tRKe7bkabdMrBH//vaQKBgQCSzkeBjasKbBW6w3Rprd+usBhMhTjeCFfQGi3SkD/hFQJjDEQAlT8KYI/qh8I59UV8R7kp3ZBPIjay8AvVrCJb60DmCVC+BN36/QXQ3VeovADncuSF6xw9PiExKJz6etN4b/QRfQWOdSXhcieef7NX45MdOFjQyb1Gu0nliuOaIwKBgCrzv1LY/GPNSBDYzICTJcR4YRZmmil8INCU/fJXI7k0TQj6LHLpSeDxfND0GJxVeEd7omt3h4IlSdFjpzV6tbFgqHdZMUqgR0taVvluhUzqFEbhM0shlh95w4iXMOQIHsnvDFVy8hs9Fy1TunlVRvZPrFf6svLa9eHM9ZMkuVehAoGBAJKA5u9pgpB5fXEgZN54EUOOovx2s7QZbjotAJoL+lrB09jWKD3ai7rhV0voXYb4JNleZtBti7onkxxuQ1gMhHNWa4AX2RLSPlntxsE167gxf6CX5colmSK4tEaKVaVGosPEpD8F+Aij9Y9ajWf0FpA9BVeHrTkcQmHY3538xrcA";
    // 支付宝公钥
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlVDPD5klpMJUCJ/HDoBKvlOvD3y8dqzTd6hW6RL2+SRezRxPRMHPphk55RKa699ekhqwQfPaVVRuYViY1naHAr5171uf5Z239Gl1uU2MQ+1s3f4IgCsoB8FuBVZPEeQEFrhJ6OF+hSV08zT+WK+uWMMgRSxZqUeNtAjhc/XrRvzigD5pcDMBPRzVL6ncPrECayovpmREFdrlWoFFtrWezjHcHHb5m8BVTxYHq4jCgTypfUF9r1vOohzqECdIcUad9i1KRhnVVbxLOd0FnEEAsvF6NBdGo7QZpa1obNq3TDi8FNGuSO8gG1v7lqVp3BX1fme1oqRWnd7KQNf8uoqXywIDAQAB";
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String SIGN_TYPE= "RSA2";
    private final String FORMAT = "json";
    private final String CHARSET="utf8";
    private final String signType= "RSA2";
    @ResponseBody
    @PostMapping(value = "/pay/alipay")
    public String alipay(HttpSession session,
                         @RequestBody Order order) throws AlipayApiException {
        System.out.println(order);
        String order_num = order.getO_order();
        String order_money = order.getO_price();
        String subject = "书本";
        //调用封装好的方法（给支付宝接口发送请求）

        return sendRequestToAlipay(order_num,order_money,subject);
    }
    @ResponseBody
    @GetMapping(value = "/pay/aliQuery/{o_order}")
    public String aliQuery(@PathVariable(value = "o_order")String o_order)throws AlipayApiException{
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,signType);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", o_order);
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        return response.getBody();
    }

    private String sendRequestToAlipay(String outTradeNo,String totalAmount,String subject) throws AlipayApiException {
        //获得初始化的AlipayClient            gatewayUrl, appId, privateKey, format, charset, publicKey, signType
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,signType);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();


        //商品描述（可空）
        String body="";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","
                + "\"total_amount\":\""+ totalAmount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result =   alipayClient.pageExecute(alipayRequest).getBody();


        return result;
    }

}
