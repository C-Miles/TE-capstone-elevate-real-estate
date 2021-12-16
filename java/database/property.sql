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
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Legacy Pointe', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 1);
INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 1500, 1, 1);

INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, 2, 'A', 1200, 1, 1);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '211 E Kelso Rd', 'Columbus', 'OH', 43202);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Clintonville Way', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 2);
INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 1500, 2, 2);

INSERT INTO address (address_id, address, city, state, zip) VALUES (DEFAULT, '6700 Allister Way', 'Columbus', 'OH', 43235);
INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, 'Sawmill', 'https://firebasestorage.googleapis.com/v0/b/delta-elevate.appspot.com/o/aptComplex.jpeg?alt=media&token=e2531f08-0d3a-4927-9e92-7c1503830afd', 3);
INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, 3, 'C', 1500, 3, 3);

-- SELECT COUNT(property_name, image_name, unit_id, rooms, monthly_rent, address, apartment_number, city, state, zip), property.property_id 
SELECT COUNT(property_name, image_name, address, apartment_number, city, state, zip) AS test, property.property_id 
AS property_id FROM property 
JOIN unit ON property.property_id = unit.property_id
JOIN address ON property.address_id = address.address_id
GROUP BY property.property_id
ORDER BY test;

SELECT COUNT(property_name) AS properties_list, property.property_id
FROM property
GROUP BY property.property_id;