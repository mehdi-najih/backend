package com.example.demo.validation;

import org.springframework.stereotype.Service;

@Service
public class CustomValidation {

 public boolean checNamelength(String firstName,String lastName , String emailId ){
     if(firstName.length() >3 && lastName.length() >3 && emailId.length() >3){
         return  true;
     }else {
         return false;
     }
 }


}
