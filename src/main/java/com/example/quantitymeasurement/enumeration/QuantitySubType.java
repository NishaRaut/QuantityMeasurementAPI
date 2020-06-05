package com.example.quantitymeasurement.enumeration;

public enum QuantitySubType {
    FEET(12,QuantityType.LENGTH),INCH(1,QuantityType.LENGTH),YARD(36,QuantityType.LENGTH),CM(1/2.5,QuantityType.LENGTH),
    GALLON(3.78,QuantityType.VOLUME),LITRE(1,QuantityType.VOLUME),ML(1/1000,QuantityType.VOLUME),
    KG(1,QuantityType.WEIGHT),GRAM(1d/1000,QuantityType.WEIGHT),TONNE(1000,QuantityType.WEIGHT),
    CELSIUS(1,QuantityType.TEMPRATURE),FAHRANHIT(1-32/1.8,QuantityType.TEMPRATURE);

public double conversionValue;
public QuantityType quantityType;

    QuantitySubType(double conversionValue, QuantityType quantityType) {
        this.conversionValue = conversionValue;
        this.quantityType = quantityType;
    }
}
