package com.pbt.ambulance_app.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.Area;


@Repository
public interface AreaRepository  extends CrudRepository<Area, Integer>{

    Area findByAreaId(int areaId); 
}
