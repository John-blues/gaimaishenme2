package gai.maishenme.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


public class JsonBinder {


    private ObjectMapper mapper;

    public JsonBinder(Inclusion inclusion) {
            mapper = new ObjectMapper();
            mapper.getSerializationConfig().setSerializationInclusion(inclusion);
            mapper.getDeserializationConfig().set(
                            org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonBinder buildNormalBinder() {
            return new JsonBinder(Inclusion.ALWAYS);
    }

    public static JsonBinder buildNonNullBinder() {
            return new JsonBinder(Inclusion.NON_NULL);
    }
    public static JsonBinder buildNonDefaultBinder() {
            return new JsonBinder(Inclusion.NON_DEFAULT);
    } 
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
    public String toJson(Object object) {

            try {
                    return mapper.writeValueAsString(object);
            } catch (IOException e) {
                    return null;
            }
    }
    public ObjectMapper getMapper() {
            return mapper;
    }
}
