package templating;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * Created by anton on 07.05.17.
 */
public class PageGenerator {
    public static final String HTML_DIR = "src/templates";
    private final Configuration cfg;
    private static PageGenerator pageGenerator;

    public static PageGenerator instance(){
        if (pageGenerator == null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }

    private PageGenerator(){
        cfg = new Configuration();
    }

    public String getPage(String filename, Map<String,Object> data){
        Writer stream = new StringWriter();
        try {
            Template template = cfg.getTemplate(HTML_DIR + File.separator + filename);
            template.process(data, stream);
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
            return stream.toString();

    }
}
