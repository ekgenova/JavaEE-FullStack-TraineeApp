package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements ITraineeRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	private static final Logger LOGGER = Logger.getLogger(TraineeDBRepository.class);

	public String getAllTrainees() {
		LOGGER.info("In TraineeDBRepository getAllTrainees");
		TypedQuery<Trainee> query = manager.createQuery("SELECT a FROM Account a", Trainee.class); 
		return util.getJSONForObject(query.getResultList());
	}

	@Transactional(REQUIRED)
	public String addTrainee(String trainee) {
		LOGGER.info("In TraineeDBRepository addTrainee");
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\"; \"trainee has been successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate) {
		LOGGER.info("In TraineeDBRepository updateTrainee");
		Trainee updatedTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		Trainee traineeFromDB = findTrainee(id);
		if (traineeToUpdate != null) {
			traineeFromDB = updatedTrainee;
			traineeFromDB.setId(id);
			manager.merge(traineeFromDB);
		}
		return "{\"message\": \"trainee has been successfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		LOGGER.info("In TraineeDBRepository deleteTrainee");
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee has been successfully deleted\"}";
	}
	
	private Trainee findTrainee(Long id) {
		LOGGER.info("In TraineeDBRepository findTrainee");
		return manager.find(Trainee.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
