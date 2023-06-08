package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldPrototype {
    private String name;
    private String type;
    private String modifiers;

    public FieldPrototype(Field field) {
        this.name = field.getName();
        this.type = field.getType().getSimpleName();
        this.modifiers = Modifier.toString(field.getModifiers());
    }

    @Override
    public String toString() {
        return modifiers + " " + type + " " + name + ";";
    }
}