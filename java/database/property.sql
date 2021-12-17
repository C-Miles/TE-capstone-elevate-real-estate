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
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Legacy Pointe Places', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/01-Standard%2BApartments-018.jpg?alt=media&token=15f75538-97b5-4d16-a882-4542f5142196', 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 1, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/AIMCO_apartment_interior.jpg?alt=media&token=91ced1ee-8908-4242-bf48-4cf1f7067b9b', 1150, 1, 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1300, 1, 1);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1550, 1, 1);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '221 E Kelso Rd', 'Columbus', 'OH', 43202);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Meadows Haven', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/Apartment_blocks_Sleek_Urban-0433c6.jpg?alt=media&token=9df11c37-e3ee-4dce-a5b9-a56dc6806c19', 2);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/image.jpg?alt=media&token=fa86f527-0123-4ac2-969c-ab33c0f13bdd', 1200, 2, 2);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1650, 2, 2);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '1221 Grandview Ave', 'Columbus', 'OH', 43212);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Grande Apartments', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/Galleries-September-Lightroom-2-3-c606387ade11ec25a5438e17468935da.jpg?alt=media&token=4ca4b4b4-e155-4dfe-b95b-cf05c20e56ed', 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 1, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/1400972392393.jpeg?alt=media&token=eb7125e7-fa87-46f6-8979-f57ed996c5ae', 900, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1175, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'C', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1125, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'D', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1400, 3, 3);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 4, 'E', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1800, 3, 3);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '254 West Olentangy Street', 'Powell', 'OH', 43065);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Greater Columbus Rentals', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/apartment2.jpg?alt=media&token=745f63cb-8850-408e-91ec-3bee2d192944', 4);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'A', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/Modern-apartment-in-Moscow-Diff-007.1542370629.5678.jpg?alt=media&token=fcaa4dd0-34eb-40d0-8aa9-c5f6874ece32', 1175, 4, 4);
INSERT INTO unit (unit_id, rooms, apartment_number, image_names, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'B', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1350, 4, 4);

