package com.metacube.genarator.services;

import com.metacube.genarator.entities.CounterEntity;
import com.metacube.genarator.repositories.CounterRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CounterService {
  @Autowired
  CounterRepositry counterRepositry;
  public synchronized Long getCounterValue(String counterName){
    counterRepositry.update(counterName);
    CounterEntity entity = counterRepositry.getByCounterName(counterName);
    return entity.getCounts();
  }
}
