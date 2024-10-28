package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.Statistic;


@Repository
public interface StatisticRepository  extends CrudRepository<Statistic, String>{
   Statistic findByYear(int year);

}