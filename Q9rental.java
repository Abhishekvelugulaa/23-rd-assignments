package com.projectday23;
//9. Vehicle Rental SystemDescription: Manage vehicle rentals for a business.

//Features:Classes: Vehile, Customer, Rental.Methods: Rent/return vehicles, calculate rental costs

import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double rentalRate;

    public Vehicle(String vehicleId, String model, double rentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.rentalRate = rentalRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " [ID=" + vehicleId + ", Model=" + model + ", Rate=" + rentalRate + "]";
    }
}

class Car extends Vehicle {
    public Car(String vehicleId, String model, double rentalRate) {
        super(vehicleId, model, rentalRate);
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String model, double rentalRate) {
        super(vehicleId, model, rentalRate);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}

class Client {
    private String clientId;
    private String name;

    public Client(String clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client [ID=" + clientId + ", Name=" + name + "]";
    }
}

class Rental {
    private Vehicle vehicle;
    private Client client;
    private int days;

    public Rental(Vehicle vehicle, Client client, int days) {
        this.vehicle = vehicle;
        this.client = client;
        this.days = days;
    }

    public double calculateRentalCost() {
        return vehicle.getRentalRate() * days;
    }

    @Override
    public String toString() {
        return "Rental [" + vehicle + ", " + client + ", Days=" + days + ", Cost=" + calculateRentalCost() + "]";
    }
}

public class Q9rental{
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", "Toyota Camry", 50));
        vehicles.add(new Bike("B202", "Yamaha MT-15", 20));

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("CL001", "John Doe"));
        clients.add(new Client("CL002", "Jane Smith"));

        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        System.out.println("\nClients:");
        for (Client client : clients) {
            System.out.println(client);
        }

        System.out.println("\nProcessing Rental:");
        Rental rental = new Rental(vehicles.get(0), clients.get(0), 3);
        System.out.println(rental);
    }
}

