package com.metacube.genarator.controllers;

import com.metacube.genarator.entities.StudentEntity;
import com.metacube.genarator.services.StudentService;
import com.metacube.genarator.utilities.RandomStringGenertorUtil;
import com.metacube.genarator.utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
* StudentController
*
* @author Abhishek Bishnoi
* 26-Feb-2020, 4:49 PM
*/
@Controller
@RequestMapping("/student")
public class StudentController {
  @Autowired
  StudentService service;
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:48 PM
  */
  @GetMapping
  public ResponseEntity<Object> getAllApplicationCategories() {
    if(isUserAuthorized()){
      try {
        List<StudentEntity> list = service.getAllStudents();
        return ResponseUtils.ok(list);
      }catch (Exception e){
        return  ResponseUtils.internalServer();
      }
    }
    return ResponseUtils.unauthorised();
    
  }
  
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:48 PM
  */
  @GetMapping("/{id}")
  public ResponseEntity<Object> getApplicationCategoryId(@PathVariable("id") Long id)
  {
    if(isUserAuthorized()){
      try {
        StudentEntity entity = service.getStudentById(id);
        if(entity == null){
          return ResponseUtils.notFound();
        }
        return ResponseUtils.ok(entity);
      }catch (Exception e){
        return ResponseUtils.internalServer();
      }
    }
    return ResponseUtils.unauthorised();
  }

  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:48 PM
  */
  @PostMapping
  public ResponseEntity<Object> createApplicationCategory(@Valid @RequestBody StudentEntity student)
  {
    if(isUserAuthorized()){
      try {
        StudentEntity created = service.createStudent(student);
        return ResponseUtils.created(created);
      }
      catch (Exception e){
        return ResponseUtils.internalServer();
      }
    }
    return ResponseUtils.unauthorised();
  }
  
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:49 PM
  */
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateApplicationCategory(@RequestBody StudentEntity student,
                                                          @PathVariable("id") Long id)
  {
    if(isUserAuthorized()){
      try {
        boolean updated = service.updateStudent(id, student);
        if(updated){
          return ResponseUtils.noContent();
        }
        return ResponseUtils.notFound();
      }catch (Exception e){
        return ResponseUtils.internalServer();
      }
    }
    return ResponseUtils.unauthorised();
    
  }
  
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:49 PM
  */
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteApplicationCategoryById(@PathVariable("id") Long id)
  {
    if(isUserAuthorized()){
      try{
        service.deleteStudentById(id);
        return ResponseUtils.noContent();
      }catch (Exception e){
        return ResponseUtils.internalServer();
      }
    }
    return ResponseUtils.unauthorised();
  }
  
  @GetMapping("/request-testing")
  public ResponseEntity<Object> saveTesting(){
    StudentEntity student = new StudentEntity();
    String name = RandomStringGenertorUtil.getRandomString();
    student.setName(name);
    student.setEmail(name+"@mail.domian");
    try {
      StudentEntity created = service.createStudent(student);
      return ResponseUtils.created(created);
    }
    catch (Exception e){
      return ResponseUtils.internalServer();
    }
  }
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 26-Feb-2020, 4:49 PM
  */
  private boolean isUserAuthorized() {
    return true;
  }
}
