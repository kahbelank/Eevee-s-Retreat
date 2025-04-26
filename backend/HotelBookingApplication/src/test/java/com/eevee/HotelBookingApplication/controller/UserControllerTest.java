// package com.eevee.HotelBookingApplication.controller;

// import com.eevee.HotelBookingApplication.model.User;
// import com.eevee.HotelBookingApplication.service.IUserService;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;

// import static org.mockito.Mockito.when;
// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest(UserController.class)
// class UserControllerTest {

// @Autowired
// private MockMvc mockMvc;

// @MockBean
// private IUserService userService;

// @Test
// void testGetAllUsers() throws Exception {
// List<User> userList = new ArrayList<>();
// User user = new User();
// user.setFirstName("John");
// user.setLastName("Doe");
// userList.add(user);

// when(userService.getUsers()).thenReturn(userList);

// mockMvc.perform(get("/api/users/all"))
// .andExpect(status().isOk())
// .andExpect(jsonPath("$[0].firstName").value("John"));
// }
// }
