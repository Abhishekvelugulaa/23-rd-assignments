package com.projectday23;
//10. Hotel Room Booking SystemDescription: Book and manage hotel rooms.

//Features:Classes: Room, Customer, Booking.Methods: Book/check-out rooms, check availability.Use inheritance for room types (standard, deluxe).
import java.util.*;

abstract class Room {
    private String roomId;
    private String type;
    private double pricePerNight;
    private boolean isBooked;

    public Room(String roomId, String type, double pricePerNight) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void checkOutRoom() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return type + " Room [ID=" + roomId + ", Price=" + pricePerNight + ", Booked=" + isBooked + "]";
    }
}

class StandardRoom extends Room {
    public StandardRoom(String roomId, double pricePerNight) {
        super(roomId, "Standard", pricePerNight);
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomId, double pricePerNight) {
        super(roomId, "Deluxe", pricePerNight);
    }
}

class Guest {
    private String guestId;
    private String name;

    public Guest(String guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Guest [ID=" + guestId + ", Name=" + name + "]";
    }
}

class Booking {
    private Room room;
    private Guest guest;
    private int nights;

    public Booking(Room room, Guest guest, int nights) {
        this.room = room;
        this.guest = guest;
        this.nights = nights;
    }

    public double calculateTotalCost() {
        return room.getPricePerNight() * nights;
    }

    @Override
    public String toString() {
        return "Booking [" + room + ", " + guest + ", Nights=" + nights + ", Total Cost=" + calculateTotalCost() + "]";
    }
}

public class Q10hotelbooking {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new StandardRoom("R101", 100));
        rooms.add(new DeluxeRoom("R202", 200));

        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest("G001", "Mark"));
        guests.add(new Guest("G002", "Adam"));

        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            System.out.println(room);
        }

        System.out.println("\nGuests:");
        for (Guest guest : guests) {
            System.out.println(guest);
        }

        System.out.println("\nProcessing Booking:");
        Room roomToBook = rooms.get(0);
        if (!roomToBook.isBooked()) {
            roomToBook.bookRoom();
            Booking booking = new Booking(roomToBook, guests.get(0), 3);
            System.out.println(booking);
        } else {
            System.out.println("Room is already booked!");
        }
    }
}
