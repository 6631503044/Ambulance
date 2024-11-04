package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.statistic;


@Repository
public interface StatisticRepository  extends CrudRepository<statistic, Integer>{
   statistic findByYear(int year);

}