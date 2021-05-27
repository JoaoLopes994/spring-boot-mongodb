package com.joaosilva.workshopmongo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaosilva.workshopmongo.domain.Post;
import com.joaosilva.workshopmongo.repository.PostRepository;
import com.joaosilva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepo;

	
	public Post findById(String id) {
		Optional<Post> obj = postRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> finByTitle(String text){
		return postRepo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepo.fullSearch(text, minDate, maxDate);
	}
	

}
