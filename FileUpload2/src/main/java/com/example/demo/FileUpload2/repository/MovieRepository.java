package com.example.demo.FileUpload2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.FileUpload2.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
