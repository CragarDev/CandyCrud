package com.cragardev.candycrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cragardev.candycrud.models.Candy;
import com.cragardev.candycrud.repositories.CandyRepo;

@Service
public class CandyService {
	
	// Inject the repository
	private final CandyRepo candyRepo;

	public CandyService(CandyRepo candyRepo) {
		this.candyRepo = candyRepo;
	}
	
	//
	// Find All Candy
	//
	public List<Candy> allCandys() {
		return candyRepo.findAll();
	}
	
	//
	// Create Candy
	//
	public Candy createCandy(Candy candy) {
		return candyRepo.save(candy);
		
	}
	
	//
	// Find One Candy
	//
	public Candy findCandy(Long id) {
		Optional<Candy> optionalCandy = candyRepo.findById(id);
		if(optionalCandy.isPresent()) {
			return optionalCandy.get();
		} else {
			return null;
		}
	}
	
	//
	// Update Candy
	//
	public Candy updateCandy(Candy candy) {
		return candyRepo.save(candy);
		
	}
	
	
	//
	// Delete Candy
	//
	public void deleteCandy(Long id) {
		candyRepo.deleteById(id);
		
	}
	
}
