
package edu.cibertec.cursoProducer.controller;

import edu.cibertec.curso.dao.entity.CursoEntity;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    private KafkaTemplate kafkaTemplate;
    
    @Value("${topico.nombre}")
    private String topico;
    
    @RequestMapping("/cursos/{id}")
    private CursoEntity publicarCurso(@PathVariable("id") Integer codCurso)
    {
        CursoEntity rpta=new CursoEntity(codCurso, "Java Backend 17", new Date(Calendar.getInstance().getTimeInMillis()), 12, 0, 0);
        kafkaTemplate.send(topico,rpta);
        return rpta;
    }
    
}
