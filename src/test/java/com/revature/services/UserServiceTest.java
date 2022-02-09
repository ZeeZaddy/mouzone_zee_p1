//package com.revature.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
//import java.util.Optional;
//
//import com.revature.repositories.EmployUserDAO;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.models.Role;
//import com.revature.models.Employee;
//
//public class UserServiceTest {
//
//    private static LoginService userService;
//    private static EmployUserDAO userDAO;
//
//    private Employee GENERIC_EMPLOYEE_1;
//
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        userService = new LoginService();
//        userDAO = mock(EmployUserDAO.class);
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        GENERIC_EMPLOYEE_1 = new Employee(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
//    }
//
//    @Test
//    public void testGetByUsernamePassesWhenUsernameExists() {
//        when(userDAO.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
//
//        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), userService.getByUsername(GENERIC_EMPLOYEE_1.getUsername()));
//
//        verify(userDAO).getByUsername(GENERIC_EMPLOYEE_1.getUsername());
//    }
//}
