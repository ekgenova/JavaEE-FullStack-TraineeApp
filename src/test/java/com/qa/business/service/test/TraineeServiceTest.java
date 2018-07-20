package com.qa.business.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeService;
import com.qa.persistence.repository.ITraineeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {

	@InjectMocks
	private TraineeService traineeService;
	
	@Mock
	private ITraineeRepository repo;
	
	@Before
	public void setUp() {
		traineeService.setRepo(repo);
	}
	
	@Test
	public void testAddTrainee() {
		Mockito.when(repo.addTrainee("account info")).thenReturn("account successfully added");
		assertEquals("account successfully added", traineeService.addTrainee("account info"));
		Mockito.verify(repo).addTrainee("account info");
		Mockito.verify(repo, Mockito.never()).deleteTrainee(1L);
	}
	
	@Test
	public void testGetAllTrainees() {
		Mockito.when(repo.getAllTrainees()).thenReturn("accounts returned");
		assertEquals("accounts returned", traineeService.getAllTrainees());
		Mockito.verify(repo).getAllTrainees();
		Mockito.verify(repo,Mockito.never()).deleteTrainee
		(1L);
	}
	
	@Test
	public void testUpdateAccount() {
		Mockito.when(repo.updateTrainee(1L, "account info")).thenReturn("account successfully updated");
		assertEquals("account successfully updated", traineeService.updateTrainee(1L, "account info"));
		Mockito.verify(repo).updateTrainee(1L, "account info");
		Mockito.verify(repo, Mockito.never()).addTrainee("account info");
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(repo.deleteTrainee(1L)).thenReturn("account successfully deleted");
		assertEquals("account successfully deleted", traineeService.deleteTrainee(1L));
		Mockito.verify(repo).deleteTrainee(1L);
		Mockito.verify(repo, Mockito.never()).addTrainee("1L");
	}
}