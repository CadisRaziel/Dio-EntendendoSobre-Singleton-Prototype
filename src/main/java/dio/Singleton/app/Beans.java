package dio.Singleton.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {

    //@Scope("prototype")
    //cada referencia vai ter um objeto pertinente
    //cada vez que o spring tiver uma nova referencia dos objetos abaixos ele ja vai saber que deve existir respectivos objetos por sua necessidade
    //    @Autowired
    //    private Remetente noreply;
    //    @Autowired
    //    private Remetente techTeam;

    @Bean
    @Scope("prototype") //->cada referencia vai ter um
    public Remetente remetente(){
        System.out.println("CRIANDO UM OBJETO REMETENTE");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");
        remetente.setNome("Digital Innovation One");
        return remetente;
    }
}
