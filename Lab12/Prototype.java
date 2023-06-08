package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Prototype {
    private String packageName;
    private String className;
    private String superclassName;
    private List<String> interfaces = new ArrayList<>();
    private String modifiers;
    private List<FieldPrototype> fields = new ArrayList<>();
    private List<MethodPrototype> methods = new ArrayList<>();

    public Prototype(Class<?> clazz) {
        this.packageName = clazz.getPackage().getName();
        this.className = clazz.getSimpleName();
        this.superclassName = clazz.getSuperclass().getSimpleName();
        for (Class<?> interfaceClass : clazz.getInterfaces()) {
            this.interfaces.add(interfaceClass.getSimpleName());
        }
        this.modifiers = Modifier.toString(clazz.getModifiers());
        for (Field field : clazz.getDeclaredFields()) {
            this.fields.add(new FieldPrototype(field));
        }
        for (Method method : clazz.getDeclaredMethods()) {
            this.methods.add(new MethodPrototype(method));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(packageName).append(".").append(className).append(" extends ").append(superclassName);
        if (!interfaces.isEmpty()) {
            sb.append(" implements ").append(String.join(", ", interfaces));
        }
        sb.append(" { \n");
        for (FieldPrototype field : fields) {
            sb.append("  ").append(field).append("\n");
        }
        for (MethodPrototype method : methods) {
            sb.append("  ").append(method).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }




}
