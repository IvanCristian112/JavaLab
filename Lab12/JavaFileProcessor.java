package org.example;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;


public class JavaFileProcessor {

    private TestRunner testRunner = new TestRunner();

    public void processJavaFile(String filePath) {
        File javaFile = new File(filePath);
        if (!javaFile.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        if (javaFile.getName().endsWith(".java")) {
            // Compile the .java file
            compileJavaFile(javaFile);

            // Replace the file extension to get the path of the compiled .class file
            String classFilePath = filePath.replace(".java", ".class");  // Updated here
            File classFile = new File(classFilePath);
            System.out.println(javaFile);
            System.out.println(classFile);
            if (classFile.exists()) {
                try {
                    //testRunner.exploreClass(javaFile,classFile);
                    URLClassLoader urlClassLoader = null;
                    URL[] urls = {classFile.getParentFile().toURI().toURL()};
                    urlClassLoader = new URLClassLoader(urls);
                    String className = javaFile.getName().replace(".java", "");
                    Class<?> clazz = urlClassLoader.loadClass(className);
                    testRunner.processClass(clazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Compilation did not produce a .class file: " + classFilePath);
            }
        } else {
            System.out.println("Input file must be a .java file.");
        }
    }

    private void compileJavaFile(File javaFile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String classpath = javaFile.getParent(); // get the directory of the javaFile
        System.out.println();
        int result = compiler.run(null, null, null, "-cp", classpath, javaFile.getPath());

        if (result != 0) {
            System.out.println("Compilation failed for file: " + javaFile.getPath());
        }
    }

}
