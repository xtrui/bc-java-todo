package com.oocl.todo.utils;

public class TodoIsValid {
    public static <T> void isValid(T param) {
        if (param == null) {
            throw new IllegalArgumentException("你给的参数不对");
        }
    }
}
