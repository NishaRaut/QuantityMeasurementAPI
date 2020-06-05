package com.example.quantitymeasurement.service;

import com.example.quantitymeasurement.dto.UnitConversionDTO;
import com.example.quantitymeasurement.enumeration.QuantitySubType;
import com.example.quantitymeasurement.enumeration.QuantityType;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.quantitymeasurement.enumeration.QuantitySubType.CELSIUS;
import static com.example.quantitymeasurement.enumeration.QuantitySubType.FAHRANHIT;

@Service
public class QuantityMeasurementService {
    public List<QuantityType> getMaimUnits() {
        System.out.println("service"+Arrays.asList(QuantityType.values()));
        return Arrays.asList(QuantityType.values());
    }

    public List<QuantitySubType> getSubUnits(QuantityType quantityType) {
        List<QuantitySubType> quantitySubTypes;
        quantitySubTypes = Arrays.stream(QuantitySubType.values()).filter(quantitySubType -> quantitySubType.quantityType.equals(quantityType))
                .collect(Collectors.toList());
        return quantitySubTypes;
    }

    public Double getConvertValue2(UnitConversionDTO unitConversionDTO) throws Exception {
        double outPutValue;
        if (unitConversionDTO.initialUnit.equals(CELSIUS) && unitConversionDTO.outputUnit.equals(FAHRANHIT)) {
            outPutValue = ((unitConversionDTO.initialValue * unitConversionDTO.initialUnit.conversionValue) + 32);
        } else if (unitConversionDTO.initialUnit.equals(FAHRANHIT) && unitConversionDTO.outputUnit.equals(CELSIUS)) {
            outPutValue = ((unitConversionDTO.initialValue - 32) * unitConversionDTO.initialUnit.conversionValue);
        } else {
            System.out.println(unitConversionDTO.initialValue);
            System.out.println( unitConversionDTO.initialUnit.conversionValue);
            System.out.println(unitConversionDTO.outputUnit.conversionValue);
            outPutValue = (unitConversionDTO.initialValue * unitConversionDTO.initialUnit.conversionValue) / unitConversionDTO.outputUnit.conversionValue;
       }
        return outPutValue;

    }
}
