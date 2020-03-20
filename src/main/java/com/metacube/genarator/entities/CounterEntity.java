package com.metacube.genarator.entities;

import javax.persistence.*;

@Entity
@Table(name="counter")
public class CounterEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "counter_name")
  private String counterName;
  @Column(name = "counts", nullable = false, columnDefinition = "int default 0")
  private  Long counts;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getCounterName() {
    return counterName;
  }
  
  public void setCounterName(String counterName) {
    this.counterName = counterName;
  }
  
  public Long getCounts() {
    return counts;
  }
  
  public void setCounts(Long counts) {
    this.counts = counts;
  }
}
