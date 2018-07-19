package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.ITraineeRepository;

public class TraineeService implements ITraineeService {

	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);
	
	@Inject
	private ITraineeRepository repo;
	
	public String getAllTrainees() {
		LOGGER.info("In TraineeService getAllTrainees");
		return repo.getAllTrainees();
	}

	public String addTrainee(String trainee) {
		LOGGER.info("In TraineeService addTrainee");
		return repo.addTrainee();
	}

	public String updateTrainee(Long id, String trainee) {
		LOGGER.info("In TraineeService updateTrainee");
		return repo.updateTrainee();
	}

	public String deleteTrainee(Long id) {
		LOGGER.info("In TraineeService deleteTrainee");
		return repo.deleteTrainee();
	}
	
	public void setRepo(ITraineeRepository repo) {
		LOGGER.info("In TraineeService setRepo");
		this.repo = repo;
	}

}
