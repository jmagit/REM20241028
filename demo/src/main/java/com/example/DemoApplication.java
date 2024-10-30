package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;

import com.example.aop.AuthenticationService;
import com.example.aop.introductions.Visible;
import com.example.ioc.NotificationService;
import com.example.ioc.NotificationServiceImpl;
import com.example.ioc.Rango;
import com.example.ioc.basico.ClaseNoComponente;
import com.example.ioc.basico.ConfiguracionImpl;
import com.example.ioc.basico.Cualifica;
import com.example.ioc.basico.RepositorioImpl;
import com.example.ioc.basico.Servicio;
import com.example.ioc.basico.ServicioImpl;
import com.example.ioc.multiple.ConstructorConValores;
import com.example.ioc.multiple.Sender;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		
//		Servicio srv = new ServicioImpl(new RepositorioImpl(new ConfiguracionImpl()));
//		var contexto = new AnnotationConfigApplicationContext(AppConfig.class);
////		Servicio srv = contexto.getBean(Servicio.class);
////		srv.add();
////		contexto.getBean(ClaseNoComponente.class).saluda();
////		contexto.getBean(NotificationService.class).getListado().forEach(System.out::println);
////		contexto.getBean(Sender.class).send("un mensaje");
//		contexto.close();
	}

//	@Bean
//	public CommandLineRunner demoAmbito(Servicio srv, NotificationService notificaciones, ConstructorConValores kk) {
//		return args -> {
//			notificaciones.add("desde App");
//			System.out.println(" ---------------- ");
//			notificaciones.getListado().forEach(System.out::println);
//			System.out.println(" ---------------- ");
//			System.out.println(srv);
//			System.out.println(" ---------------- ");
//			srv.add();
//			var cad = notificaciones.getMessage(0);
//			System.out.println(cad.orElse("Vacio"));
//			kk.titulo("sr", "amarillo");
//			kk.titulo("amarillo");
////			kk.titulo(null, "amarillo");
//		};
//	}

//	@Bean
//	public CommandLineRunner demoAOP(Servicio srv, ConstructorConValores kk, AuthenticationService auth) {
//		return args -> {
////			try {
//////				srv.add();
////				kk.titulo("algo");
////				kk.titulo("sr", "amarillo");
////				System.out.println(kk.dameValor("un valor").orElse("sin valor"));
////			} catch (Exception e) {
////				System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage() + (e.getCause()!=null ? " Motivo: " + e.getCause().getMessage() : ""));
////			}
////			auth.login();
////			srv.add();
////			if(srv instanceof Visible v) {
////				System.err.println(v.isVisible() ? "Visible" : "Invisible");
////				v.mostrar();
////				System.err.println(v.isVisible() ? "Visible" : "Invisible");
////				v.ocultar();
////				System.err.println(v.isVisible() ? "Visible" : "Invisible");
////			}
////			System.err.println(srv.getClass());
//			try {
//				srv.get();
//			} catch (Exception e) {
//				System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage() + (e.getCause()!=null ? " Motivo: " + e.getCause().getMessage() : ""));
//			}
//		};
//	}

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
//	@Bean
//	public CommandLineRunner demoProfile(Servicio srv) {
//		return args -> {
//			srv.add();
//		};
//	}
	
//	@Value("${mi.valor:valor por defecto}")
//	String miValor;
//	@Autowired
//	Rango rango;

//	@Bean
//	public CommandLineRunner cotilla(@Value("${mi.valor:valor por defecto}") String miValor, Rango rango) {
//		return args -> {
//			System.err.println("-----> El valor es '" + miValor + "'");
//			System.err.println("-----> El valor es '" + rango + "'");
//		};
//	}

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

//	@Bean
//	public CommandLineRunner demoJDBC(JdbcTemplate db, JdbcClient client) {
//		return args -> {
//			record Vet(int id, String firstName, String lastName) {}
//			class VetRowMapper implements RowMapper<Vet> {
//
//				@Override
//				public Vet mapRow(ResultSet row, int index) throws SQLException {
//					return new Vet(row.getInt(1), row.getString("first_name"), row.getString(3));
//				}
//				
//			}
////			try {
//				System.out.println("Nº Veterinarios: " + db.queryForObject("select count(*) from vets", Integer.class));
//				var vet = db.queryForObject(
//						"select * from vets where id=?", 
//						(row, index) -> new Vet(row.getInt(1), row.getString("first_name"), row.getString(3))
//						, 2);
//				System.out.println(vet);
//				var newId = db.update(
//						"insert into vets(first_name,last_name) values(?, ?)", 
//						"Pepito", "Grillo");
//				vet = db.queryForObject(
//						"select * from vets where id=?", 
//						new VetRowMapper()
//						, newId);
//				System.out.println(vet);
//				db.query(
//						"select * from vets", 
//						new VetRowMapper()
//						)
//				.forEach(System.out::println);
//				
////			} catch (SQLException e) {
////				System.err.println(e.getMessage());
////			}
//		};
//	}
	@Bean
	public CommandLineRunner demoJdbcClient(JdbcClient db) {
		return args -> {
			record Vet(int id, String firstName, String lastName) {}
			System.out.println("Nº Veterinarios: " + db
					.sql("select count(*) from vets")
					.query(Integer.class)
					.single());
			System.out.println("Nº Veterinarios: " + db
					.sql("select * from vets where id=?")
					.param(3)
					.query(Vet.class)
					.single());
			var reg = new Vet(0, "Pepito", "Grillo");
			db.sql("insert into vets(first_name,last_name) values(:firstName, :lastName)")		
				.paramSource(reg)
				.update();

			db.sql("select * from vets")
				.query(Vet.class)
				.list()
				.forEach(System.out::println);
			System.out.println("Nº Veterinarios: " + db
					.sql("select * from vets where id=:id_vet")
					.param("id_vet", 6)
					.query(Vet.class)
					.single());
				
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//			}
		};
	}

//	@EventListener
//	void onEvent(String event) {
//		System.err.println("EVENTO: " + event);
//	}


}
