package com.example.demo.FileUpload2.conroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileUpload2.entity.Movie;
import com.example.demo.FileUpload2.repository.MovieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MovieController {
	@Autowired
	private MovieRepository movieRepo;
	@PostMapping("/postdata")
public ResponseEntity<?> postData(@RequestParam("file") MultipartFile file,@RequestParam("name") String name) throws IOException
{
	Movie movie=new Movie();
	String movieName=file.getOriginalFilename();
	movie.setName(name);
	movie.setImage(file.getBytes());
	movie.setFileName(movieName);
	movieRepo.save(movie);
	return ResponseEntity.ok().body(movie);
	
}
	@GetMapping("/getdata")
	public List<Movie> getMovies()
	{
		return movieRepo.findAll();
	}
}
