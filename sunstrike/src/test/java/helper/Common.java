package helper;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Common {
    public static void logDomTree(String pageSource) throws IOException {
        File file = new File("dom.xml");
        FileUtils.writeStringToFile(file, WebDriverRunner.source(), StandardCharsets.UTF_8);
    }
}
