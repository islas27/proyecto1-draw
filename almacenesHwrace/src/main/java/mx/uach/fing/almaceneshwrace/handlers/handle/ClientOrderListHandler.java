/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.handle;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.FMConfig;
import mx.uach.fing.almaceneshwrace.handlers.payloads.EmptyPayload;
import mx.uach.fing.almaceneshwrace.models.Order;

/**
 *
 * @author Jonathan
 */
public class ClientOrderListHandler extends AbstractRequestHandler<EmptyPayload>{
    
    List<Order> lo;

    @Override
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
        try {
            //Obtenemos instancia de la configuracion del FreeMarker
            Configuration fmcfg = FMConfig.getInstance();
            //Armado del template y salida a web (Por cada ruta en la aplicacion)
            StringWriter writer = new StringWriter();
            Template homeTemplate = fmcfg.getTemplate("home.ftl");
            lo = Order.findByUser(s.attribute("uid"));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("username", s.attribute("name"));
            parametros.put("orders", lo);
            homeTemplate.process(parametros, writer);
            return new Answer(200, writer.toString());
        } catch (IOException | TemplateException ex) {
            Logger.getLogger(ClientOrderListHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Answer(400);
    }
    
}
