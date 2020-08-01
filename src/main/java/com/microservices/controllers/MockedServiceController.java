package com.microservices.controllers;

import com.microservices.model.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MockedServiceController {

    public static int counter =0;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {
            "application/JSON"
    })
    public ResponseEntity<ResponseObject> testService() {

        counter++;

        ResponseObject responseObject = new ResponseObject();

       if (counter <= 10)
            return ResponseEntity.ok(responseObject);

        else if (counter > 10 && counter <= 15){
            responseObject.setResult("Success");
          return ResponseEntity.ok(responseObject);
        }

        else {
            responseObject.setResult("Failure");
            counter=0;
           return ResponseEntity.ok(responseObject);
        }



    }
}
