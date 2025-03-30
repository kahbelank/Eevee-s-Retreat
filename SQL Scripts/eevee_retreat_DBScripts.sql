-- Create the database
CREATE DATABASE IF NOT EXISTS eevee_retreat;
USE eevee_retreat;

-- Create the Role table
CREATE TABLE IF NOT EXISTS role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create the User table
CREATE TABLE IF NOT EXISTS `user` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the Room table
CREATE TABLE IF NOT EXISTS room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(50) NOT NULL,
    room_price DECIMAL(10, 2) NOT NULL,
    is_booked BOOLEAN DEFAULT 0,
    photo BLOB
);

-- Create the BookedRoom table
CREATE TABLE IF NOT EXISTS booked_room (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    guest_full_name VARCHAR(100) NOT NULL,
    guest_email VARCHAR(100) NOT NULL,
    adults INT NOT NULL,
    children INT NOT NULL,
    total_guest INT NOT NULL,
    confirmation_code VARCHAR(50) NOT NULL,
    room_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id),
    FOREIGN KEY (user_id) REFERENCES `user`(id)
);

-- Create the user_roles join table
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES `user`(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

-- INSERT DATA 
-- Insert dummy data into the Role table
INSERT INTO role (name) VALUES ('ADMIN'), ('USER');

-- Insert dummy data into the User table
INSERT INTO `user` (first_name, last_name, email, password) VALUES 
('John', 'Doe', 'john.doe@example.com', 'password123'),
('Jane', 'Smith', 'jane.smith@example.com', 'password456'),
('Alice', 'Brown', 'alice.brown@example.com', 'password789');

-- Insert dummy data into the Room table
INSERT INTO room (room_type, room_price, is_booked, photo) VALUES 
('Single', 100.00, 0, NULL),
('Double', 150.00, 0, NULL),
('Suite', 250.00, 0, NULL);

-- Insert dummy data into the BookedRoom table
INSERT INTO booked_room (check_in, check_out, guest_full_name, guest_email, adults, children, total_guest, confirmation_code, room_id, user_id) VALUES 
('2025-04-10', '2025-04-15', 'John Doe', 'john.doe@example.com', 2, 1, 3, '1234567890', 1, 1),
('2025-05-01', '2025-05-05', 'Jane Smith', 'jane.smith@example.com', 1, 0, 1, '0987654321', 2, 2);

-- Insert dummy data into the user_roles join table
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),  -- John Doe is an ADMIN
(2, 2),  -- Jane Smith is a USER
(3, 2);  -- Alice Brown is a USER

-- Optionally update room status to indicate that booked rooms are marked as booked
UPDATE room SET is_booked = true WHERE id IN (1, 2);

-- If you want to delete user roles (commented out for now)
-- DELETE from user_roles;
