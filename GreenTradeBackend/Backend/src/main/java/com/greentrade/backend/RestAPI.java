package com.greentrade.backend;

import com.greentrade.backend.service.SysBranchService;
import com.greentrade.common.entity.SysBranchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/")
public class RestAPI {

    @Autowired
    private SysBranchService sysBranchService;


//    @GetMapping("/branch/{codex}")
    @RequestMapping(value = "/branch", method = RequestMethod.GET, produces = "application/json")
    public List<SysBranchImpl> getSysBranchByCode() throws Exception {
        return sysBranchService.getSysBranchByCode("1");
    }
}
