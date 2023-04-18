package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestUt {
    public static <T> T call(Object obj, String methodName, Object... args) {
        try {
            Class<?>[] argTypes = Arrays.stream(args)
                    .map(Object::getClass)
                    .toArray(Class<?>[]::new);

            Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
            return (T) method.invoke(obj, args);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}