package com.eevee.HotelBookingApplication.strategy;

import com.eevee.HotelBookingApplication.model.BookedRoom;
import java.util.List;

public interface AvailabilityStrategy {
    boolean isRoomAvailable(BookedRoom newBooking, List<BookedRoom> existingBookings);
}
