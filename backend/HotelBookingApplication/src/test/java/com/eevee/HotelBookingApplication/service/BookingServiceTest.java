package com.eevee.HotelBookingApplication.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.eevee.HotelBookingApplication.exception.InvalidBookingRequestException;
import com.eevee.HotelBookingApplication.model.BookedRoom;
import com.eevee.HotelBookingApplication.model.Room;
import com.eevee.HotelBookingApplication.repository.BookingRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private IRoomService roomService;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBookingSuccess() {
        Room room = new Room();
        room.setBookings(new ArrayList<>());

        BookedRoom booking = new BookedRoom();
        booking.setCheckInDate(LocalDate.now().plusDays(1));
        booking.setCheckOutDate(LocalDate.now().plusDays(3));

        when(roomService.getRoomById(anyLong())).thenReturn(Optional.of(room));
        when(bookingRepository.save(any(BookedRoom.class))).thenReturn(booking);

        String code = bookingService.saveBooking(1L, booking);
        assertNotNull(code);
    }

    @Test
    void testSaveBookingRoomUnavailable() {
        Room room = new Room();
        BookedRoom booking = new BookedRoom();
        booking.setCheckInDate(LocalDate.now().plusDays(2));
        booking.setCheckOutDate(LocalDate.now().plusDays(1)); // Invalid booking

        when(roomService.getRoomById(anyLong())).thenReturn(Optional.of(room));

        assertThrows(InvalidBookingRequestException.class, () -> {
            bookingService.saveBooking(1L, booking);
        });
    }
}
