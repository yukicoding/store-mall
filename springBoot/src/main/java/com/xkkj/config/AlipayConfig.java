package com.xkkj.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000120609082";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCo/mAaNcmV8S8dSKmfXCPlb8XQBWcrmvuJAbF3X20qHy8ynAucFq9+5xWDXaiV23U2yLl4SRb/TnzDZ/R1tJo3NDKM4NmTZmRfR82vGua8SMiTg/0Duqck3ZSZhJ+ZRvFxlyVygrWzVPeui0yGwYWEyXIN4G6mGoyKhxetE0Ve3GY2MOWkYnG3aM5gqCDBIEkWFisuihqCfVHe4BsnCvyMDr2X6fziF1vDMG38FKJrK9T53Nq4tSbdcPVS39UU8paqESJQDQdKU3R94ufbA9BH9xgJpGKAOPonC+NwwKEjU6fndKFHdKV35m08qvsQNFmcLJgF2y6cccButfilfGz5AgMBAAECggEBAJrneN3tmdeImcBE/76krf68ot0YZsaQrKqcU7jxTtZCeXfxk67DGKDBX3Xn3wVmgZ3zBhddH+hsYG6ZlnpiTs31WbTK0oWLYMv5vG8awI+sQ7b8UGsfp+Bh/7ls2QKeBekyO9AoQjec1eA3rbEEKMhcAuD3bVVylorQZAJw3LCi5stUJ+hGVvHr7kl4G8EfNSgZPWFAbqc1SjD6V+yn9dvufia/b/ZPfkO7VX4o7gya5aYp4zHsHkrKC74qtCYJ8fku0QWPJGnDG/Re9gmPmFWWuoNLijFfUUgNtzAsfY+NKasy3hSkyEra/TqqHnYfVpv0M2OKBp9YUORr3QrPu5UCgYEA1nq1NpMfKfqDDweAeA/iG0TV6ei6yTLiadNTLjGjSlf0ohc384/XM6kZBNcpSWb46DgTwHpxiofKcPKPZa8e0251/ZfXFy3QQG/DwgCViLzYRe1Fntdi26LOooMDB6xqmR7ufNZahCaIXIrdvsdmZcWJcUsZprMz3wSeIaWzam8CgYEAybV2Pa4rZd+8T+rWFJiqxevQvQyywNknN+Dqlbr3xTXPMLLD7n34spp3Tk68RkWp/mqScXa6Nx/xCiSrKScQTjHoZQuHzi13ezCmB9IC+/yQphTCSgQRe63zXwye5Yk5IDPjxkGxlEgImdA+hsUR9m6zWQQfyApiLt4z1w5ScxcCgYEA0ShzJdiNcJubSYHQV8Vtg5g6X9SUqvcTc44hNRA1JJ/nslagOsaQYBHMkzrcSXfAzn05TeBab3UDB+iTzN7dWeUD7Z0wpasIxn330m5NZT58Tp0X4tI61uPLTRIkV0xd3BsdCeLj/LGzE0RdANpl0mO0KCbLyhRCRn+zUi7Ma8MCgYBj+cggbEpgVRO+PLRdQwopzWcJvNiAk2FH5ff/vMr/+Vq3VXOdqtxwkfUeYBIbdn36dxIcoO9NUUykbWZUoGMJjt0T8DIgtBJrgcJZT/NguF9tog5mpzuPJLni25uKQ4iH+JAl/PuqdkWlDz1eiSENFvNX5J5oBRWDC2mAZz3ggwKBgEO/au5ZS7AnXZzEEBRMD5psRViH3rRkUZkbX96ptIylK4FYqF0gc7d79kKgtFzecvDlHR8q24S/x4iLrL50/XofgSox9UHlTvjaiw/dzLeGXnNUBCgHvVoXHt6zAikU9dsNGVvOAo7klsz0kewmI9fWnyNIncSV5nwKdG+YGGo0";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiA9ahjgZn7vgqqdvRO3OSjOpxACTyHyvBpUyW/slgG+g57RNu7KV1oZI21bQy7074Rw289Pi/ImZjRcw7L9O6z9Z2rqfaWB0OzY5kYDyGL/eXj1KGThHB2b5quQTfy9+2UlsrlaD2tTXbSsl96g/OkhEKtIL9Bo9PJjIbRiIPtg1Me7gEOw1eu/9RKr3KYwAYBV811Cn2G0cbZBQH/Np6r+HMidjbahpSE4b2fM98bU3FMtXrpZ2f931lCM1r9kXUGdrR0uF/czJH4QUqcTiSwYatFfKJ4fHaT9UCMAx5MU8vlXaArlXQzFAGjFax9ms1zrz2IMaXm+VCmTIASecAwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8083/alipay/notifyUrl";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
	public static String return_url = "http://localhost:8083/alipay/returnUrl";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关(沙盒环境)
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


}

