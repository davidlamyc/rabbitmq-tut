package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import com.course.rabbitmq.producer.producer.HumanResourceProducer;
import com.course.rabbitmq.producer.producer.PictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PictureProducer producer;

	// valid sources
	private final List<String> SOURCES = List.of("mobile","web");

	// valid types
	private final List<String> TYPES = List.of("jpg","png","svg");

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			var picture = new Picture();
			picture.setName("Picture " + 1);
			picture.setSize(ThreadLocalRandom.current().nextLong(1,10000));
			picture.setSource(SOURCES.get(i % SOURCES.size()));
			picture.setType(TYPES.get(i % TYPES.size()));

			producer.sendMessage(picture);
		}
	}
}
