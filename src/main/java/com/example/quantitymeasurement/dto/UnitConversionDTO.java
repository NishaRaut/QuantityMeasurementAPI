package com.example.quantitymeasurement.dto;

import com.example.quantitymeasurement.enumeration.QuantitySubType;
import com.example.quantitymeasurement.enumeration.QuantityType;

public class UnitConversionDTO {
    public QuantityType units;
    public QuantitySubType initialUnit;
    public double initialValue;
    public QuantitySubType outputUnit;
}