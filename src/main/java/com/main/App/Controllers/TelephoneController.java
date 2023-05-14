package com.main.App.Controllers;

import com.main.App.Models.Telephone;
import com.main.App.Payload.Request.TelephoneRequest;
import com.main.App.Payload.Response.TelephoneResponse;
import com.main.App.Service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth/telephone")
@CrossOrigin
public class TelephoneController {
    @Autowired
    TelephoneService telephoneService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(telephoneService.findAll());
    }

    @GetMapping("/{id}")
    public Telephone getTelephoneById(@PathVariable Long id){
        return telephoneService.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<TelephoneResponse> add(@RequestBody TelephoneRequest tp){
        Telephone telephone = new Telephone(tp.getDdd(), tp.getNumber());

        Telephone newTelephone = telephoneService.save(telephone);

        TelephoneResponse response = new TelephoneResponse(newTelephone.getId(), newTelephone.getDdd(), newTelephone.getNumber());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TelephoneRequest tp){
        Telephone findTelephone = telephoneService.findById(id);

        if (findTelephone != null){
            findTelephone.setDdd(tp.getDdd());
            findTelephone.setNumber(tp.getNumber());

            Telephone updatedTelephone = telephoneService.save(findTelephone);

            TelephoneResponse response = new TelephoneResponse(updatedTelephone.getId(), updatedTelephone.getDdd(), updatedTelephone.getNumber());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        telephoneService.delete(id);
    }
}
