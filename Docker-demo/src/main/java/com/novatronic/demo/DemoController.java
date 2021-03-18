package com.novatronic.demo;

import com.novatronic.demo.bean.BeanConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);
    
    @Autowired
    private Configuration configuration;
    
    @Value("${valores.valor_fijo}")
    String valorFijo;

    @Value("${valores.valor_funcion}")
    String valorFuncion;

    /**
     *
     * @param basic
     * @return
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET, value = "hello")
    public ResponseEntity<RespondeDemo> sayHello() {
        ResponseEntity reply;
        try {
            reply = new ResponseEntity<>(new RespondeDemo("hola"), HttpStatus.OK);

        } catch (Exception ex) {
            LOG.error("Erro en servicio", ex);
            reply = new ResponseEntity<>(new RespondeDemo("hola"), HttpStatus.OK);
        }

        return reply;
    }

    @GetMapping("/limites")
    public BeanConfiguration getConfiguracion() {
        return new BeanConfiguration(configuration.getMinimum(),
                configuration.getMaximum(), valorFijo, valorFuncion);
    }

}

class RespondeDemo {

    private String name;

    public RespondeDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RespondeDemo{" + "name=" + name + '}';
    }

}
