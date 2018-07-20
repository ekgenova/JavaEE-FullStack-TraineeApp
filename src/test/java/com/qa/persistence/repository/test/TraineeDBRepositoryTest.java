package com.qa.persistence.repository.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepositoryTest {

	@InjectMocks
	private TraineeDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"John\",\"secondName\":\"Doe\"}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"Doe\"}";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainee = new ArrayList<Trainee>();
		trainee.add(new Trainee("John", "Doe", null));
		Mockito.when(query.getResultList()).thenReturn(trainee);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}
	
	@Test
	public void testCreateAccount() {
		String reply = repo.addTrainee(MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"account has been sucessfully added\"}");
	}
	
	@Test
	public void testUpdateAccount() {
		String reply = repo.updateTrainee(1L, MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"account sucessfully updated\"}");
	}
	
	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteTrainee(1L);
		assertEquals(reply, "{\"message\": \"account sucessfully deleted\"}");
	}
}