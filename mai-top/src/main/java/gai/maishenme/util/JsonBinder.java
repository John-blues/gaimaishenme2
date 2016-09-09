/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015��5��11�� 
 * 
 *******************************************************************************/ 
package gai.maishenme.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


/**
 * <pre>
 * ҵ����:
 * ����˵��: 

 */
public class JsonBinder {


    private ObjectMapper mapper;

    public JsonBinder(Inclusion inclusion) {
            mapper = new ObjectMapper();
//            //�������ʱ�������Եķ��
            mapper.getSerializationConfig().setSerializationInclusion(inclusion);
//            //��������ʱ������JSON�ַ����д��ڵ�Java����ʵ��û�е�����
            mapper.getDeserializationConfig().set(
                            org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
//            mapper.getSerializationConfig().withSerializationInclusion(inclusion);
//            mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * �������ȫ�����Ե�Json�ַ�����Binder.
     */
    public static JsonBinder buildNormalBinder() {
            return new JsonBinder(Inclusion.ALWAYS);
    }

    public static JsonBinder buildNonNullBinder() {
            return new JsonBinder(Inclusion.NON_NULL);
    }

    /**
     * ����ֻ�����ʼֵ���ı�����Ե�Json�ַ�����Binder.
     */
    public static JsonBinder buildNonDefaultBinder() {
            return new JsonBinder(Inclusion.NON_DEFAULT);
    } 
    
    /**
     * ���JSON�ַ���ΪNull��"null"�ַ���,����Null.
     * ���JSON�ַ���Ϊ"[]",���ؿռ���.
     * 
     * �����ȡ������List/Map,�Ҳ���List<String>���ּ�����ʱʹ���������:
     * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {});
     */
    public <T> T fromJson(String jsonString, Class<T> clazz) {
            if (jsonString==null || jsonString.length()==0) {
                    return null;
            }
            try {
                    return mapper.readValue(jsonString, clazz);
            } catch (IOException e) {
                    return null;
            }
    }

    /**
     * �������ΪNull,����"null".
     * �������Ϊ�ռ���,����"[]".
     */
    public String toJson(Object object) {

            try {
                    return mapper.writeValueAsString(object);
            } catch (IOException e) {
                    return null;
            }
    }

    /**
     * ȡ��Mapper����һ�������û�ʹ���������л�API.
     */
    public ObjectMapper getMapper() {
            return mapper;
    }
}
