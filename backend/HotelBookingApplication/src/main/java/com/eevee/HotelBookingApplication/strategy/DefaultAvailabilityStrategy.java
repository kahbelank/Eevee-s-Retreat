package com.eevee.HotelBookingApplication.strategy;

import com.eevee.HotelBookingApplication.model.BookedRoom;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultAvailabilityStrategy implements AvailabilityStrategy {

    @Override
    public boolean isRoomAvailable(BookedRoom newBooking, List<BookedRoom> existingBookings) {
        for (BookedRoom existing : existingBookings) {
            if (newBooking.overlapsWith(existing)) {
                return false;
            }
        }
        return true;
    }
}
