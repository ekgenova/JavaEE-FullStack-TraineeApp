package com.qa.business.service;

public interface ITraineeService {

	String getAllTrainees();
	
	String addTrainee(String trainee);
	
	String updateTrainee(Long id, String trainee);
	
	String deleteTrainee(Long id);
}
