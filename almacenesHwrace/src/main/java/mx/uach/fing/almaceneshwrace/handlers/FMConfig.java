package mx.uach.fing.almaceneshwrace.handlers;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Clase Singleton para obtener instancia de la configuracion del FreeMarker
 * Created by Jonathan on 04/09/2015.
 * @author Jonathan
 * @version 1.0
 */
public class FMConfig {
    private static Configuration ourInstance;

    /*
    * @return instancia de  FreeMarker Configuration
    * @throws IOException cuando no encuentra la carpeta de los templates
    * */
    public static Configuration getInstance() throws IOException {
        if (ourInstance == null){
            //Configuracion del Freemarker (Deberia de hacerse una sola vez por toda la aplicacion)
            // Create your Configuration instance, and specify if up to what FreeMarker version
            Configuration freeMarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
            // Specify the source where the template files come from. Here I set a
            // plain directory for it, but non-file-system sources are possible too:
            freeMarkerConfig.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
            // Set the preferred charset template files are stored in. UTF-8 is
            // a good choice in most applications:
            freeMarkerConfig.setDefaultEncoding("UTF-8");
            ourInstance = freeMarkerConfig;
        }
        return ourInstance;
    }

    private FMConfig(){

    }
}
