package com.metacube.genarator.services;


import com.metacube.genarator.entities.StudentEntity;
import com.metacube.genarator.repositories.StudentRepositry;
import com.metacube.genarator.utilities.TemplateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
* ApplicationCategoryService
*
* @author Abhishek Bishnoi
* 19-Feb-2020, 3:10 PM
*/
@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepositry repository;
    @Autowired
    CounterService service;
    /**
    * 
 
    * @return 
    * @author Abhishek Bishnoi
    * 26-Feb-2020, 4:34 PM
    */
    public List<StudentEntity> getAllStudents(){
        List<StudentEntity> entities = repository.findAll();
        return entities;
    }

    /**
    * 
    * @return 
    * @author Abhishek Bishnoi
    * 26-Feb-2020, 4:34 PM
    */
    public StudentEntity getStudentById(Long id){
        Optional<StudentEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }

    /**
    * 
    * @return 
    * @author Abhishek Bishnoi
    * 26-Feb-2020, 4:34 PM
    */
    public StudentEntity createStudent(StudentEntity student) {
        StudentEntity entity = repository.save(student);
        Long id = service.getCounterValue("prospect_id");
        try{
            String prostectId = TemplateGenerator.getTemplate(id);
            entity.setProspectId(prostectId);
            entity = repository.save(entity);
            return entity;
        }catch (Exception e) {
            return entity;
        }
    }
    
    /**
     *
     * @return
     * @author Abhishek Bishnoi
     * 26-Feb-2020, 4:34 PM
     */
    public boolean updateStudent(Long id, StudentEntity student) {
        Optional<StudentEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            repository.save(student);
            return true;
        }
        return false;
    }
    
    /**
    *
    * @return 
    * @author Abhishek Bishnoi
    * 26-Feb-2020, 4:34 PM
    */
    public Boolean deleteStudentById(Long id){
        Optional<StudentEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
   
}
