package com.projectday23;
//6. Hospital Management SystemDescription: A simple system to manage patients, doctors, and appointments.

//Features:Classes: Patient, Doctor, Appointment.Methods: Schedule appointments, manage patient records.


class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + "]";
    }
}

class Doctor {
    private int id;
    private String name;

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + "]";
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment [Patient=" + patient.getName() + ", Doctor=" + doctor.getName() + ", Date=" + date + "]";
    }
}

public class Q6doctor {
    public static void main(String[] args) {
        try {
            Patient patient = new Patient(1, "Alice");
            Doctor doctor = new Doctor(101, "Dr. Smith");
            Appointment appointment = new Appointment(patient, doctor, "2025-01-25");

            System.out.println("Scheduled Appointment: " + appointment);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}