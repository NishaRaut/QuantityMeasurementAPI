package com.example.quantitymeasurement.controller;
import com.example.quantitymeasurement.dto.UnitConversionDTO;
import com.example.quantitymeasurement.enumeration.QuantitySubType;
import com.example.quantitymeasurement.enumeration.QuantityType;
import com.example.quantitymeasurement.response.Response;
import com.example.quantitymeasurement.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuantityMeasurementController {
    @Autowired
   private QuantityMeasurementService quantityMeasurementService;


    @GetMapping("/unit/type")
    public ResponseEntity getAllQuantityTypes() {
        List<QuantityType> quantityTypes = quantityMeasurementService.getMaimUnits();
        Response response = new Response("Retrivinng all main unit types", 200, quantityTypes);
        System.out.println("response" + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("unit/subtype")
            public ResponseEntity getAllQuantitySubtype(@RequestParam(value = "quantityType") QuantityType quantityType){
        List<QuantitySubType> quantitySubTypes = quantityMeasurementService.getSubUnits(quantityType);
        Response response = new Response("Retriving all sub unit types", 200,quantitySubTypes);
        return new ResponseEntity(response,HttpStatus.OK);

        }
//        @PostMapping("/conversion")
//    public  UnitConversionDTO getConvertedValue(@RequestParam QuantityType type,@RequestParam QuantitySubType initialUnit,
//                                             @RequestParam QuantitySubType conversionType, @RequestParam Double initialValue) throws Exception {
//            UnitConversionDTO unitConversionDTO=quantityMeasurementService.getConvertValue(type,initialUnit,conversionType,initialValue);
//            return unitConversionDTO;
//        }
    @PostMapping("/conversions")
    public  ResponseEntity getConvertedValue2(@RequestBody UnitConversionDTO unitConversionDTO) throws Exception {
      Double result=quantityMeasurementService.getConvertValue2(unitConversionDTO);
        Response response = new Response("conversion success", 200,result);
        return new ResponseEntity(response,HttpStatus.OK);
    }


}
