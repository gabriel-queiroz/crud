package com.gabriel.crud;

import com.gabriel.crud.model.WeekDay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.DayOfWeek;
import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
		LocalDate date = LocalDate.now();
		System.out.println(date.getDayOfWeek().equals(DayOfWeek.FRIDAY));
	}

}
