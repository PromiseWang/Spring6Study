import org.example.bean.AnnotationApplicationContext;
import org.example.bean.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * Author: Promise
 * Date: 2024-02-08 13:42
 * Description:
 */

public class testMySpring {
    public static void pathDemo1(String basePackage) {
        // 1. 将包名中的"."替换为"/", 形成路径
        String packagePath = basePackage.replaceAll("\\.", "/");

        // 2. 获取包的绝对路径(编译后)
        try {
            Enumeration<URL> paths = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (paths.hasMoreElements()) {
                URL url = paths.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                System.out.println(filePath);
                // 包的扫描

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testMySpring01() {
        pathDemo1("org.example");
    }
}
