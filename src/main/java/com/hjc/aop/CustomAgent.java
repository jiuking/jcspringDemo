package com.hjc.aop;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/***
 * https://www.cnblogs.com/ctgulong/p/5011614.html 参见链接。将该打成jar包 JVM配置 -javaagent:jagent.jar即可生成对应的
 * class文件
 * @author hjc
 */
public class CustomAgent implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new CustomAgent());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.startsWith("java") && !className.startsWith("sun")) {
            // 既不是java也不是sun开头的
            // 导出代码
            int lastIndexOf = className.lastIndexOf("/") + 1;
            String fileName = className.substring(lastIndexOf) + ".class";
            exportClazzToFile("E:/javaeeworkspace/bytecode/exported/", fileName, classfileBuffer);
            System.out.println(className + " --> EXPORTED Succeess!");
        }
        return classfileBuffer;
    }

    /**
     *
     * @param dirPath
     *目录以/结尾，且必须存在
     * @param fileName
     * @param data
     */
    private void exportClazzToFile(String dirPath, String fileName, byte[] data) {
        try {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dirPath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            System.out.println("exception occured while doing some file operation");
            e.printStackTrace();
        }
    }
}
