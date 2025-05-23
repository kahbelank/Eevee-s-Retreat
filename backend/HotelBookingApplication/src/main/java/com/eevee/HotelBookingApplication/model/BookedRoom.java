package com.eevee.HotelBookingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_in")
    private LocalDate checkInDate;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    @Column(name = "guest_fullName")
    private String guestFullName;

    @Column(name = "guest_email")
    private String guestEmail;

    @Column(name = "adults")
    private int NumOfAdults;

    @Column(name = "children")
    private int NumOfChildren;

    @Column(name = "total_guest")
    private int totalNumOfGuest;

    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String status;
    private String details;

    public void calculateTotalNumberOfGuest() {
        this.totalNumOfGuest = this.NumOfAdults + NumOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    /**
     * Returns true if this booking period overlaps with the other booking.
     */
    public boolean overlapsWith(BookedRoom other) {
        // Two intervals [A, B] and [C, D] overlap iff A ≤ D && C ≤ B
        return !this.checkInDate.isAfter(other.checkOutDate)
            && !other.checkInDate.isAfter(this.checkOutDate);
    }

    // Save current state
    public BookingMemento saveState() {
        return new BookingMemento(this.status, this.details);
    }

    // Restore to previous state
    public void restoreState(BookingMemento memento) {
        this.status = memento.getStatus();
        this.details = memento.getDetails();
    }
}
