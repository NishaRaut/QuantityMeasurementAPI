package com.example.quantitymeasurement;

import com.example.quantitymeasurement.controller.QuantityMeasurementController;
import com.example.quantitymeasurement.enumeration.QuantityType;
import com.example.quantitymeasurement.response.Response;
import com.example.quantitymeasurement.service.QuantityMeasurementService;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
class QuantityMeasurementApiApplicationTests {
@Autowired
WebApplicationContext webApplicationContext;
@Autowired
Gson gson;
@Autowired
MockMvc mockMvc;
@MockBean
QuantityMeasurementService quantityMeasurementService;

    @Before
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.gson = new Gson();
    }

    @Test
    void givenQuantityMeasurement_ShouldReturnMainUnits() throws Exception {
        List<QuantityType> quantityTypeList = new ArrayList<>();
        quantityTypeList.add(QuantityType.LENGTH);
        quantityTypeList.add(QuantityType.VOLUME);
        quantityTypeList.add(QuantityType.WEIGHT);
        quantityTypeList.add(QuantityType.TEMPRATURE);
        given(quantityMeasurementService.getMaimUnits()).willReturn(quantityTypeList);
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/type")).andReturn();
//                .andDo(print()).andExpect(content().json("{\"statusCode\":200,\"message\":\"Retring all main unit types\",}"
//                                +"\data\":[\"LENGTH\",\"VOLUME\",\"WEIGHT\",\"TEMPRATURE"]));
        String response = mvcResult.getResponse().getContentAsString();
        Response responceDto = gson.fromJson(response,Response.class);
        List<QuantityType> quantityTypes = (List<QuantityType>) responceDto.data;
        Assert.assertEquals(4,quantityTypes.size());
        System.out.println(response);
      Assert.assertEquals(quantityTypeList.get(0).toString(),quantityTypes.get(0));

    }
}
