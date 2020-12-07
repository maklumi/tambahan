package com.example.utama;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//import com.haiwan.Kambing;
import com.repositories.UserDao;

import model.disini.User;

@Component
public class Pelari implements CommandLineRunner {

//	@Autowired
//	Kambing kambing;

	private UserDao userDao;
	
	@Override
	public void run(String... args) throws Exception {
//		kambing.mengembek();

		var user1 = new User("Jambatan", "sudah@roboh.com");
		userDao.save(user1);
		
		var bilangan = userDao.count();
		System.out.println(bilangan);
	}

//	@Bean
//	public Kambing seekorKambing() {
//		return new Kambing();
//	}
}
