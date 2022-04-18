package com.cragardev.candycrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cragardev.candycrud.models.Owner;
import com.cragardev.candycrud.repositories.OwnerRepository;

@Service
public class OwnerService {
	
	//Inject the repository
	private final OwnerRepository ownerRepostory;

	public OwnerService(OwnerRepository ownerRepostory) {
		super();
		this.ownerRepostory = ownerRepostory;
	}
	
	//
	// Find All Owners
	//
	public List<Owner> allOwners() {
		return ownerRepostory.findAll();
	}
	
	//
	// Create Owner
	//
	public Owner createOwner(Owner owner) {
		return ownerRepostory.save(owner);
	}
	
	//
	// Find One Owner
	//
	public Owner findOwner(Long id) {
		Optional<Owner> optionalOwner = ownerRepostory.findById(id);
		if(optionalOwner.isPresent()) {
			return optionalOwner.get();
		} else {
			return null;
		}
	}
	
	
	//
	// Update Owner
	//
	
	
	//
	// Delete Owner
	//
	
	
	
	

}
