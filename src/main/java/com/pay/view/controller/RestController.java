package com.pay.view.controller;

import com.pay.view.model.*;
import com.pay.view.service.ResultPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/service")
public class RestController {

    @Autowired
    private ResultPaymentService resultPaymentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json" )
    public @ResponseBody  List<PayView> search(@RequestBody Search model) {
        return resultPaymentService.test(model);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<Recipient> searchById(@RequestParam String id)
    {
        return resultPaymentService.getInfoById(id);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<String> getDate()
    {
        return resultPaymentService.getDate();
    }

    @RequestMapping(value = "/deduction", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<Deduction> getInfoDeduction(@RequestParam String rid, @RequestParam String cid, @RequestParam String pstart, @RequestParam String pend)
    {
        return resultPaymentService.getInfoDeduction(rid, cid, pstart, pend);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<All> getInfoAll(@RequestParam String rid)
    {
        return resultPaymentService.getInfoAll(rid);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody  List<Persons> getPersons(@RequestParam String pstart, @RequestParam String pend)
    {
        return resultPaymentService.getPersons(pstart, pend);
    }
}
