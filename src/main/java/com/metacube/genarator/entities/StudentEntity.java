package com.metacube.genarator.entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class StudentEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name="email")
  private String email;
  @Column(name="prospect_id")
  private String prospectId;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getProspectId() {
    return prospectId;
  }
  
  public void setProspectId(String prospectId) {
    this.prospectId = prospectId;
  }
}
