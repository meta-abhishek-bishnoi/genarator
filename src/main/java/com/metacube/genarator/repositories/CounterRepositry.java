package com.metacube.genarator.repositories;

import com.metacube.genarator.entities.CounterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("counterRepositry")
public interface CounterRepositry extends JpaRepository<CounterEntity, Long>{
  CounterEntity getByCounterName(String counterName);
  @Transactional
  @Modifying
  @Query("UPDATE CounterEntity SET counts = counts+1 WHERE counter_name like %?1% ")
  void update(String counterName);
}
