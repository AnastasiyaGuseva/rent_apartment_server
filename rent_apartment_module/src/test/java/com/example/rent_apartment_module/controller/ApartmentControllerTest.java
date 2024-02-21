//package com.example.rent_apartment_module.controller;
//
//import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
//import com.example.rent_apartment_module.service.ApartmentService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RequiredArgsConstructor
//class ApartmentControllerTest {
//
//    @MockBean
//    private ApartmentService apartmentService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testRegistrationNewApartment() throws Exception {
//        //void whenGetRegistrationPage() throws Exception {
//        //        this.mockMvc.perform(get("/formRegistration"))
//        //                .andDo(print())
//        //                .andExpect(status().isOk())
//        //                .andExpect(view().name("users/registration"));
//        ApartmentInfoDto apartmentInfoDto = ApartmentInfoDto.builder()
//                .price(100)
//                .street("Отважная")
//                .roomsCount(2)
//                .city("Samara")
//                .homeNumber("1")
//                .build();
//
//        mockMvc.perform(
//                        post("/add_apartment")
//                                .content(objectMapper.writeValueAsString(apartmentInfoDto))
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isCreated());
//
//    }
////            mockMvc.perform(post("/add_apartment")
////                    .expect(status().isCreated());
//
//
//    }
//
//    @Test
//    void registrationNewApartment() {
//
//    }
//
//    @Test
//    void countAverageRating() {
//    }
//
//    @Test
//    void showApartmentForBooking() {
//    }
//
//    @Test
//    void showApartmentByLocation() {
//    }
//}