-- admin: admin_id (pk), address_id
-- tenants: tenants_id (pk), address_id
-- reservations: bookings
-- property: property_id, admin_id (fk), tenants_id (fk), room_id, propertyName, city, zip
-- Address: address_id, admin_id, tenant_id, property_id, address, address 1, city, state
-- room_id: # of room, price of room, availability, # of tenants, tenants_id
-- property: property_id, admin_id (fk), tenants_id (fk), room_id, propertyName, address_id
-- Address: address_id, admin_id, tenant_id, property_id, address, address 1, city, state
-- room_id: # of room, price of room, availability, # of tenants, tenants_id
DROP TABLE if exists application;
DROP TABLE if exists unit;
DROP TABLE if exists property;
DROP TABLE if exists address;
DROP TABLE if exists payment_details;


CREATE TABLE address (address_id serial primary key,
        address varchar(64) not null,
        city varchar(32) not null,
        state varchar(2) not null,
        zip integer);
CREATE TABLE property (property_id serial primary key,
        property_name varchar(64),
        image_name varchar(50),
        address_id bigint,
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id)
        );
CREATE TABLE unit (unit_id serial primary key,
        rooms int,
        apartment_number varchar(2),
        monthly_rent numeric(18,2),
        address_id bigint,
        property_id bigint,
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id),
        CONSTRAINT fk_property_id foreign key (property_id) references property(property_id)
        );
        
CREATE TABLE payment_details (
        payment_details_id serial primary key,
        user_id bigint,
        unit_id bigint,
        credit_card bigint,
        expiration_date varchar(5),
        cvc int,
        amount int,
        payment_approved boolean,
        
        CONSTRAINT fk_username foreign key (user_id) references users(user_id)
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
           
                
       INSERT INTO address (address, city, state, zip) VALUES ('129 Central Park Place', 'New York', 'NY', 11101);
       INSERT INTO property (property_name, image_name, address_id) VALUES ('High Grand Flats', 'highgrand.jpg', 1);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (1, 'A', 1500, 1, 1);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (2, 'B', 1800, 1, 1);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (3, 'C', 2000, 1, 1);
       INSERT INTO address (address, city, state, zip) VALUES ('79 Arrowhead', 'Kansas City', 'KS', 23568);
       INSERT INTO property (property_name, image_name, address_id) VALUES ('Emerald Estates Drive', 'emerald-estates.jpg', 2);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (1, 'A', 900, 2, 2);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (2, 'B', 1200, 2, 2);
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (3, 'C', 1500, 2, 2);
       INSERT INTO payment_details (payment_details_id, user_id, unit_id, credit_card, expiration_date, cvc, amount, payment_approved) VALUES (default, 1, 1, 123453223432, 'wow', 200, 200, true);
       INSERT INTO application (rent_app_id, first_name, last_name, email_address, phone_number, application_status, unit_id) VALUES (default, 'Woohoo', 'Boohoo', 'woohooboohoo@yahoo.com', '513-645-3987', 'approved', 1);


       -- list of properties
       SELECT property_name, image_name, rooms, monthly_rent, address, apartment_number, property.property_id AS property_id, city, state, zip FROM property
       JOIN unit ON property.property_id = unit.property_id
       JOIN address ON property.address_id = address.address_id;
       -- list of properties
       SELECT * FROM property;
       JOIN address ON property.address_id = address.address_id;
       -- list of units
       SELECT * FROM unit;
       SELECT * FROM address;
       START TRANSACTION;
       
       INSERT INTO property (property_name, image_name, address_id) VALUES (1, 1, 1) RETURNING property_id;
       ROLLBACK;
       INSERT INTO property (property_name, image_name, address_id) VALUES (?, ?, ?);
       INSERT INTO address (address_id, address, city, state, zip) VALUES (default, 'testing', 'testing', 'te', 00000) RETURNING address_id;
       
INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, 1, 'C', 1000, 2, 2) RETURNING 6;
