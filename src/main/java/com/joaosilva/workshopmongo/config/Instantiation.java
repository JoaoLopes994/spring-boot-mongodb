package com.joaosilva.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaosilva.workshopmongo.domain.Post;
import com.joaosilva.workshopmongo.domain.User;
import com.joaosilva.workshopmongo.dto.AuthorDto;
import com.joaosilva.workshopmongo.repository.PostRepository;
import com.joaosilva.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		
		User maria = new User(null, "Maria Brown", "mariabrown@gmail.com");
		User alex = new User(null, "Alex green", "alexgreen@gmail.com");
		User bob = new User(null, "Bob Grey", "bobgrey@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem!", "Vou viajar para São Paulo! Abraçooo", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2020"), "Bom dia", "Acordei feliz hoje :)", new AuthorDto(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
