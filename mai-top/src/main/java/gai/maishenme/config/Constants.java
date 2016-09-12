package gai.maishenme.config;

public class Constants {
	public static final String INIT_USER_INFO = "userInfo";
	public static int OPERATOR;
	//屏幕宽高
	public static int SCREEN_WIDTH = 0;
	public static int SCREEN_HEIGHT = 0;
	// 版本code
	public static int VERSIONCODE;
	// 版本名
	public static String VERSIONNAME;
	// 系统版本
	public static int SYSTEM_VERSION;
	// 初始化请求标示
	public static int INIT_POST_IDENTIFIER = 100;
	public static int SHILI= ++INIT_POST_IDENTIFIER; 
	public static int CONNECTION_TIME_OUT= 25*1000;
	// 取消请求标示
	public static final int CANCEL_POST_IDENTIFIER = ++INIT_POST_IDENTIFIER;
	public static final int INVESTMENTS_LIST = ++INIT_POST_IDENTIFIER;//���Խӿڶ�
	public static final int TEXT=++INIT_POST_IDENTIFIER;
	//模块请求标识列表
	public static final int LOGIN=++INIT_POST_IDENTIFIER;
	//商城列表
	public static final int SHOPLISTTEST=++INIT_POST_IDENTIFIER;
}
