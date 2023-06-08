package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class MethodPrototype {
    private String name;
    private String returnType;
    private String modifiers;
    private List<String> parameterTypes = new ArrayList<>();

    public MethodPrototype(Method method) {
        this.name = method.getName();
        this.returnType = method.getReturnType().getSimpleName();
        this.modifiers = Modifier.toString(method.getModifiers());
        for (Class<?> parameterType : method.getParameterTypes()) {
            this.parameterTypes.add(parameterType.getSimpleName());
        }
    }

    @Override
    public String toString() {
        return modifiers + " " + returnType + " " + name + "(" + String.join(", ", parameterTypes) + ");";
    }
}