-- admin: admin_id (pk), address_id
-- tenants: tenants_id (pk), address_id
-- reservations: bookings 
-- property: property_id, admin_id (fk), tenants_id (fk), room_id, propertyName, city, zip
-- Address: address_id, admin_id, tenant_id, property_id, address, address 1, city, state
-- room_id: # of room, price of room, availability, # of tenants, tenants_id

-- property: property_id, admin_id (fk), tenants_id (fk), room_id, propertyName, address_id
-- Address: address_id, admin_id, tenant_id, property_id, address, address 1, city, state
-- room_id: # of room, price of room, availability, # of tenants, tenants_id

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
        address_id bigint,
        
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id)
        );
        
CREATE TABLE unit (unit_id serial primary key,
        rooms int,
        apartment_number varchar (2),
        monthly_rent numeric(18,2),
        address_id bigint,
        property_id bigint,
        
        CONSTRAINT fk_address_id foreign key (address_id) references address(address_id),
        CONSTRAINT fk_property_id foreign key (property_id) references property(property_id)
        );
       
             
       INSERT INTO address (address, city, state, zip) VALUES ('129 Central Park Place', 'New York', 'NY', 11101);
        
       INSERT INTO property (property_name, address_id) VALUES ('High Grand Flats', 1);
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (1, 'A', 1500, 1, 1); 
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (2, 'B', 1800, 1, 1);
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (3, 'C', 2000, 1, 1);
       
       INSERT INTO address (address, city, state, zip) VALUES ('79 Arrowhead', 'Kansas City', 'KS', 23568);
        
       INSERT INTO property (property_name, address_id) VALUES ('Emerald Estates Drive', 2);
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (1, 'A', 900, 2, 2); 
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (2, 'B', 1200, 2, 2);
       
       INSERT INTO unit (rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (3, 'C', 1500, 2, 2);
       
       -- list of properties
       SELECT property_name, rooms, monthly_rent, address, apartment_number, property.property_id AS property_id, city, state, zip FROM property
       JOIN unit ON property.property_id = unit.property_id
       JOIN address ON property.address_id = address.address_id;
       
       -- list of properties
       SELECT * FROM property
       JOIN address ON property.address_id = address.address_id;

       
       -- list of units
       SELECT * FROM unit;
       SELECT * FROM address;