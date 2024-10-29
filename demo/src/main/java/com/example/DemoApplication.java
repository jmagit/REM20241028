package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.ioc.NotificationService;
import com.example.ioc.NotificationServiceImpl;
import com.example.ioc.basico.ClaseNoComponente;
import com.example.ioc.basico.ConfiguracionImpl;
import com.example.ioc.basico.Cualifica;
import com.example.ioc.basico.RepositorioImpl;
import com.example.ioc.basico.Servicio;
import com.example.ioc.basico.ServicioImpl;
import com.example.ioc.multiple.Sender;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		
//		Servicio srv = new ServicioImpl(new RepositorioImpl(new ConfiguracionImpl()));
		var contexto = new AnnotationConfigApplicationContext(AppConfig.class);
//		Servicio srv = contexto.getBean(Servicio.class);
//		srv.add();
//		contexto.getBean(ClaseNoComponente.class).saluda();
//		contexto.getBean(NotificationService.class).getListado().forEach(System.out::println);
//		contexto.getBean(Sender.class).send("un mensaje");
		contexto.close();
	}

//	@Bean
//	public CommandLineRunner demo1(Sender fileSender, NotificationService notificaciones) {
//		return args -> {
//			fileSender.send("un mensaje");
//			notificaciones.add("algo");
//			notificaciones.getListado().forEach(System.out::println);
//		};
//	}
//	@Bean
//	public CommandLineRunner demoCualifica(@Qualifier("remoto") Cualifica item, @Qualifier("local") Sender comoQuiero) {
//		return args -> {
//			item.guarda();
//			comoQuiero.send("un mensaje");
//		};
//	}
	@Bean
	public CommandLineRunner demoProfile(Servicio srv) {
		return args -> {
			srv.add();
		};
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}


}
