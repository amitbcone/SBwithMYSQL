package com.amit.sbmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SPController
{

    @Autowired
    TrefrAcceptCrit sp;

    @GetMapping("/execute")
    public String execSP()
    {
        System.out.println("inside endpoint..");
        sp.exec();
        return "success";
    }
}
