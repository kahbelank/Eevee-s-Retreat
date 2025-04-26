package com.eevee.HotelBookingApplication.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.eevee.HotelBookingApplication.model.Room;
import com.eevee.HotelBookingApplication.repository.RoomRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Collections;

class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRoomTypes() {
        when(roomRepository.findDistinctRoomTypes()).thenReturn(Collections.singletonList("Deluxe"));

        assertEquals(1, roomService.getAllRoomTypes().size());
    }

    @Test
    void testGetRoomById() {
        Room room = new Room();
        room.setId(1L);

        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));

        Optional<Room> found = roomService.getRoomById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testUpdateRoom() {
        Room existingRoom = new Room();
        existingRoom.setId(1L);
        existingRoom.setRoomType("Standard");

        when(roomRepository.findById(1L)).thenReturn(Optional.of(existingRoom));
        when(roomRepository.save(any(Room.class))).thenReturn(existingRoom);

        Room updated = roomService.updateRoom(1L, "Deluxe", BigDecimal.valueOf(150), null);
        assertEquals("Deluxe", updated.getRoomType());
    }
}
