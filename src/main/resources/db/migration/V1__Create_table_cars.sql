CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    license_plate VARCHAR(20) NOT NULL,
    speed INT NOT NULL,
    detected_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);