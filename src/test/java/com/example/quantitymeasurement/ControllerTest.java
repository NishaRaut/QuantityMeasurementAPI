package com.example.quantitymeasurement;

import com.example.quantitymeasurement.controller.QuantityMeasurementController;
import com.example.quantitymeasurement.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.EnumMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private QuantityMeasurementService lengthService;

    @InjectMocks
    private QuantityMeasurementController lengthController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(lengthController)
                .build();
    }

    @Test
    public void getAllMainUnits() throws Exception {
        RequestBuilder request = get("/unit/type")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
        Assert.assertEquals(result.getResponse().getContentAsString(),result.getResponse().getContentAsString(),result.getResponse());
    }
}
