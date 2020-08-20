package com.amit.SBwithMYSQL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.amit.sbmysql.SBwithMysqlApplication;
import com.amit.sbmysql.SPController;

@AutoConfigureMockMvc
@SpringBootTest(classes = SBwithMysqlApplication.class)
class SBwithMysqlApplicationTests
{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SPController sPController;

    @Test
    public void execTest()
    {
        try {
            mockMvc.perform(get("/Test/execute")).andExpect(status().isOk());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
