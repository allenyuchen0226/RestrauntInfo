package com.example.restrauntInfo.controller;

import com.example.restrauntInfo.dao.RestrauntDao;
import com.example.restrauntInfo.entity.Restraunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestrauntController {
    @Autowired
    private RestrauntDao restrauntDao;

    @RequestMapping(value = "/addrestraunt", headers = "Accept=application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addRestraunt(@RequestBody Restraunt restraunt) {
       restrauntDao.addRestraunt(restraunt);
    }

    @RequestMapping(value = "/getRestrauntById/{restrauntId}", method = RequestMethod.GET)
    @ResponseBody
    public Restraunt getRestrauntById(@PathVariable(value = "restrauntId")int restId) {
        return restrauntDao.getRestrauntById(restId);
    }

    @RequestMapping(value = "/getAllLAs", method = RequestMethod.GET)
    @ResponseBody
    public List<Restraunt> getAllLAs() {
        return restrauntDao.getAllLAs();
    }
}
