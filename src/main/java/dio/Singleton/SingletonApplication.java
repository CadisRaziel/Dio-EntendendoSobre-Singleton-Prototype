package dio.Singleton;

import dio.Singleton.app.SistemaMensagem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(SistemaMensagem sistema) throws Exception {
		return args -> {
			sistema.enviarConfirmacaoCadastro();
			sistema.enviarMensagemBoasVindas();

			//imagine que um outro cadastro foi realizado e preciso enviar a mensagem
			//ainda temos 1 só objeto, porém o email ta sendo enviado o do tech@dio.com.br e não o 'noreply@dio.com.br'
			//ou seja ele ta sofrendo alteração e sendo refletido em outra referencia
			//pra arruma isso usamos @Scope("prototype")(olhe na classe Beans)
			//Mesmo sendo singleton ele vai criar 2 estancias porém são singleton (ele vai ve os 2 @Autowired e vai que para cada um há a necessidade de fazer um objeto)
			sistema.enviarConfirmacaoCadastro();
		};
	}

}
