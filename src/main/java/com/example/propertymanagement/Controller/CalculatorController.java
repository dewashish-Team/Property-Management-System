package com.example.propertymanagement.Controller;

import com.example.propertymanagement.Dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    //a Restful api is just mapping of Url to a java class function.


    //taking parameter from client using @RequestParam
   @GetMapping("/add")
    public ResponseEntity<Double> add(@RequestParam("q1") Double num1, @RequestParam("q2") Double num2)
    {
        ResponseEntity<Double> responseEntity=new ResponseEntity<>(num1+num2, HttpStatus.ACCEPTED);
        return responseEntity;
    }
    //taking parameter from client using @PathVariable
    @GetMapping("/sub/{var1}/{var2}")
    public ResponseEntity<Double> subtract(@PathVariable("var1") Double num1, @PathVariable("var2") Double num2)
    {
        ResponseEntity<Double> response;
        if(num1>num2)
        {
            response=new ResponseEntity<>(num1-num2,HttpStatus.ACCEPTED);
        }
        else {
            response=new ResponseEntity<>(num2-num1,HttpStatus.ACCEPTED);
        }
        return response;
    }
     @GetMapping("/sub/{var1}")
     public ResponseEntity<Double> subtract(@PathVariable("var1") Double num1,@RequestParam("q1") Double num2,@RequestParam("q2") Double num3)
     {
         Double result=null;
         if(num1>num2)
         {
             if(num2>num3) result=num1-num2-num3;
             else result=num1-num3-num2;
         }
         else if(num2>num3)
         {
             if(num3>num1) result=num2-num3-num1;
             else result=num2-num1-num3;
         }
         else if(num3>num1)
         {
             if(num1>num2) result=num3-num1-num2;
             else result=num3-num2-num1;
         }
         else result=(num1+num2+num3)*100;
         ResponseEntity<Double> response= new ResponseEntity<>(result,HttpStatus.ACCEPTED);
         return response;
     }

     // @requestbody always use with Postmaping annotaion
     @PostMapping("/mul")
     public ResponseEntity<Double> multiply(@RequestBody CalculatorDto calculatorDto)
     {
         Double result = calculatorDto.getNum1()*calculatorDto.getNum2()* calculatorDto.getNum3()* calculatorDto.getNum4()* calculatorDto.getNum5();
         ResponseEntity<Double> response=new ResponseEntity<>(result,HttpStatus.CREATED);
         return response;
     }

}
