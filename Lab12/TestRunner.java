package org.example;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TestRunner {
    private int totalTestsRun = 0;
    private int totalTestsPassed = 0;
    private int totalTestsFailed = 0;

    public void solve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the full file path to the .class file, directory, or .jar file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try {
            processInput(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processInput(File file) throws Exception {
        if (file.isDirectory()) {
            // Handle directory
            exploreDirectory(file, file);
        } else if (file.getName().endsWith(".jar")) {
            // Handle .jar file
            exploreJar(file);
        } else if (file.getName().endsWith(".class")) {
            // Handle individual .class file
            exploreClass(file);
        } else {
            System.out.println("Input file must be a .class file, a directory, or a .jar file.");
        }
    }

    private void exploreDirectory(File rootDir, File currentDir) throws Exception {
        for (File file : currentDir.listFiles()) {
            if (file.isDirectory()) {
                exploreDirectory(rootDir, file);
            } else if (file.getName().endsWith(".class")) {
                exploreClass(file);
            }
        }
    }

    private void exploreJar(File jarFile) throws Exception {
        JarFile jar = new JarFile(jarFile);
        Enumeration<JarEntry> entries = jar.entries();

        URL[] urls = {new URL("jar:file:" + jarFile.getPath() + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }

            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            Class<?> c = cl.loadClass(className);

            // Process the class as before
            processClass(c);
        }

        jar.close();
    }

    void exploreClass(File classFile) {
        File parentDir = classFile.getParentFile();
        while (parentDir != null && !parentDir.getName().equals("classes")) {
            parentDir = parentDir.getParentFile();
        }

        if (parentDir == null) {
            System.out.println("Could not find the root directory 'classes' in the given file path.");
            return;
        }
        exploreClass(parentDir, classFile);
    }

    public void exploreClass(File rootDir, File classFile) {
        try {
            String className = Paths.get(rootDir.getPath()).relativize(Paths.get(classFile.getPath())).toString()
                    .replace(".class", "").replace(File.separator, ".");
            URLClassLoader urlLoader = new URLClassLoader(new URL[]{rootDir.toURI().toURL()});

            try {
                Class<?> clazz = urlLoader.loadClass(className);

                // Process the class as before
                processClass(clazz);
            } catch (NoClassDefFoundError e) {
                System.out.printf("Failed to fully load class %s due to missing dependency: %s%n", className, e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processClass(Class<?> clazz) throws Exception {
        System.out.println("Processing class: " + clazz.getName());

        // Print the class prototype
        Prototype prototype = new Prototype(clazz);
        System.out.println(prototype);

        if (clazz.isAnnotationPresent(Test.class)) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    totalTestsRun++;
                    try {
                        if (method.getParameterCount() == 0) {
                            // No parameters, just invoke
                            method.invoke(null);
                        } else {
                            // Generate mock values and invoke
                            Object[] args = generateMockArguments(method);
                            method.invoke(null, args);
                        }
                        totalTestsPassed++;
                    } catch (Exception ex) {
                        totalTestsFailed++;
                    }
                }
            }
        }
    }

    private Object[] generateMockArguments(Method method) {
        Random rand = new Random();
        Parameter[] parameters = method.getParameters();
        Object[] args = new Object[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            if (type.equals(int.class)) {
                args[i] = rand.nextInt();
            } else if (type.equals(String.class)) {
                args[i] = "MockString";
            }
            // ... handle other primitive types as needed ...
        }
        return args;
    }

    private void printStatistics() {
        System.out.println("\nTest Statistics:");
        System.out.println("Total tests run: " + totalTestsRun);
        System.out.println("Total tests passed: " + totalTestsPassed);
        System.out.println("Total tests failed: " + totalTestsFailed);
    }
}

