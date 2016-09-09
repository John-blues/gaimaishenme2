/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015��5��6�� 
 * 
 *******************************************************************************/ 
package gai.maishenme.config;

/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015��5��6��
 * ����:	zgz
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class Constants {
	/**
	 * ��ʼ���û���Ϣ��
	 */
	public static final String INIT_USER_INFO = "userInfo";

	public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDe85G79FkpCymgQ3jPZ5qftwFsuNpMGka8+3/JpVfe728tqAO+DQHrDroaNqu6tW6XdfhBvUir7DgLq0ZE1Zlz/HwLphLhy9a0ZEoeq3SzSw9PFQAYVc9ayIclTgcfaF6T6ENGm1NodnE9YQ24N8KoaheYdc9e1woyHnecBZodBwIDAQAB";


	// �豸(��Ӫ��)
	public static int OPERATOR;
	// ��Ļ���
	public static int SCREEN_WIDTH = 0;
	public static int SCREEN_HEIGHT = 0;
	// �汾��CODE
	public static int VERSIONCODE;
	// �汾��NAME
	public static String VERSIONNAME;
	// ϵͳ�汾
	public static int SYSTEM_VERSION;
	// ��ʼ�������ʶ
	public static int INIT_POST_IDENTIFIER = 100;
	public static int SHILI= ++INIT_POST_IDENTIFIER; 
	public static int CONNECTION_TIME_OUT= 25*1000;
	// ȡ�������ʶ
	public static final int CANCEL_POST_IDENTIFIER = ++INIT_POST_IDENTIFIER;
	public static final int INVESTMENTS_LIST = ++INIT_POST_IDENTIFIER;//���Խӿڶ�
	public static final int TEXT=++INIT_POST_IDENTIFIER;
	//ģ�������ʶ�б�
	public static final int LOGIN=++INIT_POST_IDENTIFIER;
	
	public static final int SHOPLISTTEST=++INIT_POST_IDENTIFIER;
}
