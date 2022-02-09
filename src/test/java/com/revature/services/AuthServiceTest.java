//package com.revature.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
//import java.util.Optional;
//
//import com.revature.exceptions.NewUserHasNonZeroIdException;
//import com.revature.exceptions.RegistrationUnsuccessfulException;
//import com.revature.repositories.EmployUserDAO;
//import com.revature.repositories.EmployeeUserDAO;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.exceptions.UsernameNotUniqueException;
//import com.revature.models.Role;
//import com.revature.models.Employee;
//
//public class AuthServiceTest {
//
//	private static EmployService authService;
//	private static UserService userService;
//	private static EmployeeUserDAO userDAO;
//
//	private Employee EMPLOYEE_TO_REGISTER;
//	private Employee GENERIC_EMPLOYEE_1;
//	private Employee GENERIC_FINANCE_MANAGER_1;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		authService = new EmployService();
//		userService = mock(UserService.class);
//		userDAO = mock(EmployeeUserDAO.class);
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		EMPLOYEE_TO_REGISTER = new Employee(0, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
//		GENERIC_EMPLOYEE_1 = new Employee(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
//		GENERIC_FINANCE_MANAGER_1 = new Employee(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
//	}
//
//	@Test
//	public void testRegisterFailsWhenUsernameIsTaken() {
//		when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
//
//		assertThrows(UsernameNotUniqueException.class,
//			() -> authService.register(EMPLOYEE_TO_REGISTER)
//		);
//
//		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
//		verify(userDAO, never()).create(EMPLOYEE_TO_REGISTER);
//	}
//
//	@Test
//	public void testRegisterPassesWhenUsernameIsNotTaken() {
//		when(userService.getByUsername(anyString())).thenReturn(Optional.empty());
//		when(userDAO.create(anyObject())).thenReturn(GENERIC_EMPLOYEE_1);
//
//		assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));
//
//		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
//		verify(userDAO).create(EMPLOYEE_TO_REGISTER);
//	}
//
//	@Test
//	public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
//		when(userDAO.create(anyObject())).thenThrow(new RegistrationUnsuccessfulException());
//
//		assertThrows(RegistrationUnsuccessfulException.class,
//				() -> authService.register(EMPLOYEE_TO_REGISTER)
//		);
//	}
//
//	@Test
//	public void testRegisterFailsWhenIdIsNonZero() {
//		EMPLOYEE_TO_REGISTER.setId(1000);
//
//		assertThrows(NewUserHasNonZeroIdException.class,
//				() -> authService.register(EMPLOYEE_TO_REGISTER)
//		);
//	}
//
//	@Test
//	public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() {
//		when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
//
//		assertEquals(GENERIC_EMPLOYEE_1, authService.login(GENERIC_EMPLOYEE_1.getUsername(), GENERIC_EMPLOYEE_1.getPassword()));
//
//		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
//	}
//}
