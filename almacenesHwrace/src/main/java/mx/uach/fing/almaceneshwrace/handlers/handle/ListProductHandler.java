/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.*;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.EmptyPayload;

/**
 *
 * @author jesus
 */
public class ListProductHandler extends AbstractRequestHandler<EmptyPayload> {

    public ListProductHandler(){
        super.payload = new EmptyPayload();
    }
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
         try {
            //Obtenemos instancia de la configuracion del FreeMarker
            Configuration fmcfg = FMConfig.getInstance();
            //Armado del template y salida a web (Por cada ruta en la aplicacion)
            StringWriter writer = new StringWriter();
            Template homeTemplate = fmcfg.getTemplate("Product_list.ftl");
            List<Product> lista = Product.findAll();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("products", lista);
            homeTemplate.process(parametros, writer);
            return new Answer(200, writer.toString());
        } catch (IOException | TemplateException ex) {
            Logger.getLogger(ClientOrderListHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Answer(400);
    }
}
