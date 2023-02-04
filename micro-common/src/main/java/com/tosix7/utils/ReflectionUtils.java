package com.tosix7.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射相关工具类
 */
public class ReflectionUtils {

    /**
     * 根据方法名调用指定对象
     *
     * @param object 要调用方法的对象
     * @param method 要调用的方法名
     * @param args   参数对象数据
     * @return 返回调用执行结果
     */

    public static Object invoke(Object object, String method, Object... args) {
        Object result = null;
        Class<?> clazz = object.getClass();
        Method queryMethod = getMethod(clazz, method, args);
        if (queryMethod != null) {
            try {
                result = queryMethod.invoke(object, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new NoSuchMethodException(clazz.getName() + " 类中没有找到 " + method + " 方法。");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static Method getMethod(Class<?> clazz, String name, Object[] args) {
        Method queryMethod = null;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length) {
                    boolean isSameMethod = true;
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Object arg = args[i];
                        if (arg == null) {
                            arg = "";
                        } else if (!parameterTypes[i].equals(args[i].getClass())) {
                            isSameMethod = false;
                        }
                    }
                    if (isSameMethod) {
                        queryMethod = method;
                        break;
                    }
                }
            }
        }
        return queryMethod;
    }
}
