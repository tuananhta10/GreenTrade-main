package com.greentrade.common.utils;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.*;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;

public class Utils {
    private static Logger logger = LoggingUtil.createLogger(Utils.class);
    private static BeanUtilsBean beanUtilsBean = null;
    private static final GsonBuilder gsonBuilder = initGsonBuilder();
    private static ThreadLocal<Gson> gson = new ThreadLocal<>();

    private static GsonBuilder initGsonBuilder() {
        GsonBuilder builder = new GsonBuilder()
                .setDateFormat(DateTimeUtil.jsonValueToJavaFormat)
                .serializeNulls()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(new TypeToken<Map<Object, Object>>() {
                }.getType(), new MapDeserializerDoubleAsIntFix())
                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType(), new MapDeserializerDoubleAsIntFix());
        return builder;
    }

    static {
        Date defaultValue = null;
        DateConverter dateConverter = new DateConverter(defaultValue);
        dateConverter.setPatterns(DateTimeUtil.json2JavaFormats);
        Converter intConverter = new IntegerConverter(0);
        Converter longConverter = new LongConverter(0);
        Converter doubleConverter = new DoubleConverter(0.0);
        Converter floatConverter = new FloatConverter(0.0);
        Converter booleanConverter = new LongConverter(false);

        beanUtilsBean = BeanUtilsBean.getInstance();
        beanUtilsBean.getConvertUtils().register(dateConverter, Date.class);
        beanUtilsBean.getConvertUtils().register(intConverter, Integer.class);
        beanUtilsBean.getConvertUtils().register(longConverter, Long.class);
        beanUtilsBean.getConvertUtils().register(doubleConverter, Double.class);
        beanUtilsBean.getConvertUtils().register(floatConverter, Float.class);
        beanUtilsBean.getConvertUtils().register(booleanConverter, Boolean.class);
    }

    private static Gson getJsonObject() {
        if (gson.get() == null) {
            gson.set(gsonBuilder.create());
        }
        return gson.get();
    }

    public static <T> String toJson(T obj) {
        String rs = "";
        if (!CompareUtil.isEqualsNull(obj)) {
            try {
                //String uudi = java.util.UUID.randomUUID().toString();
                //logger.info(uudi);

                //long start = System.currentTimeMillis();
                //long memstart = Runtime.getRuntime().freeMemory();
                //logger.info(String.format("%s - Free memory before (bytes): %,d", uudi, memstart));
                //System.out.println(String.format("%s - Free memory before (bytes): %,d", uudi, memstart));
                //long memend = 0L;

                if (CompareUtil.isEquals(obj.getClass(), JsonObject.class))
                    rs = getJsonObject().toJson((JsonObject) obj);
                else if (CompareUtil.isEquals(obj.getClass(), JsonArray.class))
                    rs = getJsonObject().toJson((JsonArray) obj);
                else
                    rs = getJsonObject().toJson(obj);

                //memend = Runtime.getRuntime().freeMemory();
                //long end = System.currentTimeMillis();
                //logger.info(String.format("%s - ToJson time (ms): %,d", uudi, (end - start)));
                //System.out.println((String.format("%s - ToJson time (ms): %,d", uudi, (end - start))));

                //logger.info(String.format("%s - Json msg size (bytes): %,d ", uudi, (rs.getBytes().length)));
                //System.out.println(String.format("%s - Json msg size (bytes): %,d ", uudi, (rs.getBytes().length)));

                //logger.info(String.format("%s - ToJson memory used (bytes): %,d", uudi, (memstart - memend)));
                //System.out.println(String.format("%s - ToJson memory used (bytes): %,d", uudi, (memstart - memend)));
            } catch (Exception e) {
                logger.error("toJson.:[" + obj + "]", e);
            }
        }
        return rs;
    }

    public static <T> String toJson(T obj, TypeToken type) {
        String rs = "";
        if (!CompareUtil.isEqualsNull(obj) && !CompareUtil.isEqualsNull(type)) {
            try {
                //String uudi = java.util.UUID.randomUUID().toString();
                //logger.info(uudi);

                //long start = System.currentTimeMillis();
                //long memstart = Runtime.getRuntime().freeMemory();
                //logger.info(String.format("%s - Free memory before (bytes): %,d", uudi, memstart));
                //System.out.println(String.format("%s - Free memory before (bytes): %,d", uudi, memstart));
                //long memend = 0L;

                if (CompareUtil.isEquals(obj.getClass(), JsonObject.class))
                    rs = getJsonObject().toJson((JsonObject) obj);
                else if (CompareUtil.isEquals(obj.getClass(), JsonArray.class))
                    rs = getJsonObject().toJson((JsonArray) obj);
                else rs = getJsonObject().toJson(obj, type.getType());

                //memend = Runtime.getRuntime().freeMemory();
                //long end = System.currentTimeMillis();
                //logger.info(String.format("%s - ToJson time (ms): %,d", uudi, (end - start)));
                //System.out.println((String.format("%s - ToJson time (ms): %,d", uudi, (end - start))));

                //logger.info(String.format("%s - Json msg size (bytes): %,d ", uudi, (rs.getBytes().length)));
                //System.out.println(String.format("%s - Json msg size (bytes): %,d ", uudi, (rs.getBytes().length)));

                //logger.info(String.format("%s - ToJson memory used (bytes): %,d", uudi, (memstart - memend)));
                //System.out.println(String.format("%s - ToJson memory used (bytes): %,d", uudi, (memstart - memend)));
            } catch (Exception e) {
                logger.error("toJson:[" + obj + "] type=[" + type + "]", e);
            }
        }
        return rs;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        T rs = null;
        if (!CompareUtil.isEqualsNull(clazz) && !CompareUtil.isEqualsNullOrEmpty(json)) {
            try {
                rs = getJsonObject().fromJson(json, clazz);
            } catch (Exception e) {
                logger.error("fromJson:[" + json + "] class=[" + clazz + "]", e);
            }
        }
        return rs;
    }

    public static <T> T fromJson(String json, TypeToken type) {
        T rs = null;
        if (!CompareUtil.isEqualsNull(type) && !CompareUtil.isEqualsNullOrEmpty(json)) {
            try {
                rs = getJsonObject().fromJson(json, type.getType());
            } catch (Exception e) {
                logger.error("fromJson:[" + json + "] type=[" + type + "]", e);
            }
        }
        return rs;
    }

    public static Double parseDouble(String value) {
        if (CompareUtil.isEqualsNullOrEmpty(value)) return 0D;
        Double result = Double.parseDouble(value);
        return result;
    }

    public static long parseLong(String value) {
        if (CompareUtil.isEqualsNullOrEmpty(value)) return 0;
        Long result = Long.parseLong(value);
        return result.longValue();
    }

    public static void copyProperties(Object src, Object dest) throws IllegalAccessException, InvocationTargetException {
        beanUtilsBean.copyProperties(dest, src);
    }

    public static void convertFromMapToObject(Map<String, Object> src, Object dest, Class<?> clazz) throws IllegalAccessException, InvocationTargetException {
        //Fix bug: khi chuyen xml sang json thi Multiselected values bi convert sang List trong khi server nhạn la String
        //Do do ko map duoc sang Entity -> Fix dua List ve String truoc khi map
        for (Map.Entry<String, Object> entry : src.entrySet()) {
            if (CompareUtil.isEqualsNull(entry.getValue())) continue;
            if (entry.getValue() instanceof List<?>) {
                try {
                    String fClazzName = "";
                    try {
                        fClazzName = clazz.getDeclaredField(entry.getKey()).getType().getName();
                    } catch (NoSuchFieldException e) {
                        if (!CompareUtil.isEqualsNull(clazz.getSuperclass())) {
                            fClazzName = clazz.getSuperclass().getDeclaredField(entry.getKey()).getType().getName();
                        }
                    }
                    if (CompareUtil.isEquals(fClazzName, String.class.getName())) {
                        src.put(entry.getKey(), toJson(entry.getValue()));
                }
                } catch (NoSuchFieldException e) {
                    continue;
                }
            }
        }
        beanUtilsBean.populate(dest, src);
    }

    private static Object jsonToObject(JsonElement in) {
        if (in.isJsonNull())
            return null;
        if (in.isJsonArray()) {
            List<Object> list = new ArrayList<>();
            JsonArray arr = in.getAsJsonArray();
            for (JsonElement anArr : arr) {
                list.add(jsonToObject(anArr));
            }
            return list;
        } else if (in.isJsonObject()) {
            Map<Object, Object> map = new LinkedTreeMap<>();
            JsonObject obj = in.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
            for (Map.Entry<String, JsonElement> entry : entitySet) {
                map.put(entry.getKey(), jsonToObject(entry.getValue()));
            }
            return map;
        } else if (in.isJsonPrimitive()) {
            JsonPrimitive prim = in.getAsJsonPrimitive();
            if (prim.isJsonNull())
                return null;
            else if (prim.isBoolean()) {
                return prim.getAsBoolean();
            } else if (prim.isNumber()) {
                String val = prim.getAsString();
                if (val.contains(".")) {
                    return prim.getAsDouble();
                } else {
                    return prim.getAsLong();
                }
            } else {
                String val = prim.getAsString();
                if (!CompareUtil.isEqualsNull(val))
                    val = val.trim();
                /*if (!CompareUtil.isEqualsNullOrEmpty(val) && val.startsWith("[") && val.endsWith("]")) {
                    //convert to array
                    List<String> listValue = Util.fromJson(val, new TypeToken<List<String>>() {});
                    return listValue;
                }*/
                //try parse date with format: yyyy-MM-dd HH:mm:ss (value extract from submit)
                Date date = DateTimeUtil.tryCastJsonValueToDate(val);
                if (date == null) {
                    //try parse date with format: yyyy-MM-dd'T'HH:mm:ss.SSS'Z' (value from grid with timezone)
                    date = DateTimeUtil.tryCastJsonStringToDate(val);
                    if (date == null)
                        return val;
                    else return date;
                } else return date;
            }
        }
        return null;
    }

    /*Class helper to Gson*/
    public static class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<Object, Object>> {
        @Override
        @SuppressWarnings("unchecked")
        public Map<Object, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return (Map<Object, Object>) jsonToObject(json);
        }
    }
}
