-- Create the database
CREATE DATABASE IF NOT EXISTS eevee_retreat;
USE eevee_retreat;

-- Table for Role entity
CREATE TABLE role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

-- Table for User entity (using backticks because "user" is a reserved keyword)
CREATE TABLE `user` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id)
);

-- Table for Room entity
CREATE TABLE room (
    id BIGINT NOT NULL AUTO_INCREMENT,
    roomType VARCHAR(255),
    roomPrice DECIMAL(10,2),
    isBooked BOOLEAN,
    photo BLOB,
    PRIMARY KEY (id)
);

-- Table for BookedRoom entity
CREATE TABLE booked_room (
    bookingId BIGINT NOT NULL AUTO_INCREMENT,
    check_in DATE,
    check_out DATE,
    guest_fullName VARCHAR(255),
    guest_email VARCHAR(255),
    adults INT,
    children INT,
    total_guest INT,
    confirmation_Code VARCHAR(255),
    room_id BIGINT,
    PRIMARY KEY (bookingId),
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES room(id)
);

-- Join table for Many-to-Many relationship between User and Role
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES `user`(id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role(id)
);

-- Run this later --
ALTER TABLE booked_room
ADD COLUMN user_id BIGINT,
ADD CONSTRAINT fk_user_booking FOREIGN KEY (user_id) REFERENCES `user`(id);

