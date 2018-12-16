package com.justdwiwt.jsonstyle;

import com.justdwiwt.exception.JsonTypeException;
import com.justdwiwt.util.FormatUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JSON的数组形式
 * 数组是值（value）的有序集合。一个数组以“[”（左中括号）开始，“]”（右中括号）结束。值之间使用“,”（逗号）分隔。
 */
public class JsonArray {
    private List list = new ArrayList();

    public void add(Object obj) {
        //noinspection unchecked
        list.add(obj);
    }

    public Object get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    @SuppressWarnings("unused")
    public JsonObject getJsonObject(int index) {
        Object obj = list.get(index);
        if (!(obj instanceof JsonObject)) {
            throw new JsonTypeException("Type of value is not JsonObject");
        }

        return (JsonObject) obj;
    }

    @SuppressWarnings("unused")
    public JsonArray getJsonArray(int index) {
        Object obj = list.get(index);
        if (!(obj instanceof JsonArray)) {
            throw new JsonTypeException("Type of value is not JsonArray");
        }

        return (JsonArray) obj;
    }

    @Override
    public String toString() {
        return FormatUtil.beautify(this);
    }

    @SuppressWarnings("unused")
    public Iterator iterator() {
        return list.iterator();
    }
}
