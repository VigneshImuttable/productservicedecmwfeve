package com.project.productservicedecmwfeve.exceptions;

import lombok.Getter;
import lombok.Setter;


public class ProductNotExistException extends Exception {

   public ProductNotExistException(String message){
       super(message);
   }

}
