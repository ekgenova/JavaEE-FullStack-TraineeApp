package com.qa.persistence.repository;

public interface ITraineeRepository {

	String getAllTrainees();
	
	String addTrainee(String trainee);
	
	String updateTrainee(Long id, String traineeToUpdate);
	
	String deleteTrainee(Long id);
}
