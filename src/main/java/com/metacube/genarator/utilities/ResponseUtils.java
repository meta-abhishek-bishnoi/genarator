package com.metacube.genarator.utilities;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Map;


/**
* ResponseUtils
*
* @author Abhishek Bishnoi
* 23-Feb-2020, 1:4 PM
*/
public class ResponseUtils {
  /**
  *
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:5 PM
  */
  public static ResponseEntity<Object> unauthorised(){
    return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
  }
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:40 PM
  */
  public static ResponseEntity<Object> unauthorised(MultiValueMap<String,String> heads){
    return new ResponseEntity<>(null, heads, HttpStatus.UNAUTHORIZED);
  }
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:40 PM
  */
  public static ResponseEntity<Object> ok(Object object){
    return new ResponseEntity<>(object, new HttpHeaders(), HttpStatus.OK);
  }
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:40 PM
  */
  public static ResponseEntity<Object> forbidden(){
    return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.FORBIDDEN);
  }
  /**
  * 
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:40 PM
  */
  public static ResponseEntity<Object> noContent() {
    return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
  }
  /**
  *
  * @return 
  * @author Abhishek Bishnoi
  * 23-Feb-2020, 1:42 PM
  */
  public static ResponseEntity<Object> notFound() {
    return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  /**
  *
  * @return 
  * @author Abhishek Bishnoi
  * 24-Feb-2020, 8:39 AM
  */
  public static ResponseEntity<Object> created(Object object){
    return new ResponseEntity<>(object, new HttpHeaders(), HttpStatus.CREATED);
  }
  /**
  *
  * @return 
  * @author Abhishek Bishnoi
  * 24-Feb-2020, 8:55 AM
  */
  public static ResponseEntity<Object> internalServer(){
    return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  public static ResponseEntity<Object> validation(Map<String, Object> body){
    return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
