package lindsay.devon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import lindsay.devon.spring.domain.Journal;
import lindsay.devon.spring.repository.JournalRepository;

@SpringBootApplication
public class SpringBootJournalApplication {

	@Bean // the bean is the database itself not the Journal - the journal is just an entity of the Database
	InitializingBean saveData(JournalRepository repo) {
		return() -> {
			repo.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot", "10/20/2016"));
			repo.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project", "10/20/2016"));
			repo.save(new Journal("Spring Boot Reading", "Read more about Spring Boot", "10/20/2016"));
			repo.save(new Journal("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry","10/20/2016"));
		};
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}
