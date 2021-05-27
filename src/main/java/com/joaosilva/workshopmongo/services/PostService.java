package com.joaosilva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

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
		return postRepo.findByTitleContainingIgnoreCase(text);
	}
}
