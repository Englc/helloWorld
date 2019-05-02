package de.englc.helloWorld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SimpleService {
/*
        @RequestMapping(method =  RequestMethod.POST, path = "/integration/ownerCompany",
            consumes = "application/json")
    public ResponseEntity<CreateOwnerCompanyOut> createOwnerCompany(@RequestBody CreateOwnerCompanyIn ownerCompanyIn){


    @RequestMapping(method =  RequestMethod.PUT, path = "/integration/ownerCompany/{uuid}",
            consumes = "application/json")
    public ResponseEntity<UpdateOwnerCompanyS4Out> updateOwnerCompany(
            @RequestBody UpdateOwnerCompanyS4In ownerCompanyIn, @PathVariable("uuid") String uuid){


    @RequestMapping(method = RequestMethod.GET, path = "/integration/missingConfigurationCount",
            produces = "application/json")
    */
    @RequestMapping(method = RequestMethod.GET, path = "/give")
    public ResponseEntity<String> getSomething() {

        return ResponseEntity.ok().body(getText());

    }

    String getText() {
        return "This is some text";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/giveList")
    public ResponseEntity<List<String>> getAList() {

        return ResponseEntity.ok().body(Arrays.asList(getText()));

    }

}
