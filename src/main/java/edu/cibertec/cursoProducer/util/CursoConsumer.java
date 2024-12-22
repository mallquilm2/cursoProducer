
package edu.cibertec.cursoProducer.util;

import edu.cibertec.curso.dao.entity.CursoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CursoConsumer {
    
    @KafkaListener(topics="${topico.nombre}")
    public void consumirCursos(CursoEntity curso){
        log.info("curso que viene desde Kafka: "+curso);
    }
    
}
