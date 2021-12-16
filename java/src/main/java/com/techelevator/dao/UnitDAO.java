package com.techelevator.dao;

import com.techelevator.model.Unit;

import java.util.List;

public interface UnitDAO {

    List<Unit> getAllUnitsByPropertyId(long propertyId);
    List<Unit> unitsList();
}
