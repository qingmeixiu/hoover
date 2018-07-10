package com.sinaif.hoover.utils;

public class BaiChuan {
	
	//-----------------------百川IM/百川短信/百川推送-----------------------
	public static final String URL="http://gw.api.taobao.com/router/rest";
	//http://gw.api.taobao.com/router/rest
//	public static String URL="https://eco.taobao.com/router/rest";
	public static final String APPKEY="23302981";
	public static final String SECRET="bc059a80017a780bd8e808a58dfe3a60";
	public static final String DEFAULTPWD = "xunluji";//百川Im用到
	
	
	//-----------------------百川短信消息-----------------------
	public static final Long SIGNATUREID = 1385L; // 短信签名id：寻路记
	public static final Long TEMPLATEID = 2367L;  // 模板id:
	public static final Long EXPIRETIME = 300L;		//短信失效时间
	public static final Long MobileLimit = 5L;		//短信限制条数
	public static final Long MobileLimitInTime = 60*24*60L;//短信限制条数时间
	
	//--------------------------百川Media------------------------
	
	public static final String MediaAccessKey="23301612";
	public static final String MediaAccessKeySecret="9f7e7d8dd5eb54f875e734332bb007ae";
	public static final String MediaNamespace="xljtest01";
	
	//-----------------------------百川Push-------------------------------
	public static final String TARGETALL="all";				//推送iOS所有设备
	public static final String TARGETDEVICE="device";		//推送指定设备
	public static final String TARGETACCOUNT="account";		//推送指定账号
	 
	public static final String ENVDEV="DEV";				//表示开发环境
	public static final String TARGETPRODUCT="PRODUCT";		//表示生产环境

}
