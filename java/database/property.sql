DROP TABLE if exists application;
DROP TABLE if exists payment_details;
DROP TABLE if exists unit;
DROP TABLE if exists property;
DROP TABLE if exists address;
CREATE TABLE address (address_id serial primary key,
        address varchar(64) not null,
        city varchar(32) not null,
        state varchar(2) not null,
        zip integer);
        
CREATE TABLE property (property_id serial primary key,
        property_name varchar(64),
        image_name varchar,
        address_id bigint,
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id)
        );
        
CREATE TABLE unit (unit_id serial primary key,
        rooms int,
        apartment_number varchar(2),
        image_names varchar,
        monthly_rent numeric(18,2),
        address_id bigint,
        property_id bigint,
        
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id),
        CONSTRAINT fk_property_id foreign key (property_id) references property(property_id)
        );
        
CREATE TABLE payment_details (
        payment_details_id serial primary key,
        username varchar(12),
        unit_id bigint,
        credit_card bigint,
        expiration_date varchar(5),
        cvc int,
        amount int,
        payment_approved boolean,
        
        CONSTRAINT fk_unit_id foreign key (unit_id) references unit(unit_id)
        );
        
CREATE TABLE application (
        rent_app_id serial primary key,
        first_name varchar(32) NOT NULL,
        last_name varchar(32) NOT NULL,
        email_address varchar(32) NOT NULL,
        phone_number varchar(32),
        application_status varchar(16),
        unit_id bigint,
        
        CONSTRAINT fk_unit_id foreign key (unit_id) references unit(unit_id)  
);
                
INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '170 N Champion Ave', 'Columbus', 'OH', 43203);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Legacy Pointe Places', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 1, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1150, 1, 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1300, 1, 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1550, 1, 1);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '221 E Kelso Rd', 'Columbus', 'OH', 43202);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Meadows Haven', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 2);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1200, 2, 2);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1650, 2, 2);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '1221 Grandview Ave', 'Columbus', 'OH', 43212);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Grande Apartments', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 1, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 900, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1175, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1125, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'D', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1400, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 4, 'E', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1800, 3, 3);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '254 West Olentangy Street', 'Powell', 'OH', 43065);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Greater Columbus Rentals', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 4);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1175, 4, 2);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1350, 4, 2);

