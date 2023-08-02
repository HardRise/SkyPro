package ru.hogwarts.utils;

public class MethodLoading {
    public static String getMethodName() {
        return new Exception()
                .getStackTrace()[1]
                .getMethodName();
    }
}
