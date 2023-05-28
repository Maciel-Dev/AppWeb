package com.main.App.Controllers;

import com.main.App.Payload.Request.TelephoneRequest;
import com.main.App.Payload.Response.TelephoneResponse;
import com.main.App.Repositories.TelephoneRepository;
import com.main.App.Service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth/telephone")
@CrossOrigin
public class TelephoneController {
    @Autowired
    TelephoneService telephoneService;
    @Autowired
    TelephoneRepository tr;

    @GetMapping("/get/{perfilFk}")
    public List<TelephoneResponse> getTelephoneById(@PathVariable Long perfilFk){
        return ResponseEntity.ok().body(telephoneService.getPhonesByPerfil(perfilFk)).getBody();
    }

    @PostMapping("/post")
    public ResponseEntity<TelephoneResponse> create(@RequestBody TelephoneRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(telephoneService.create(req));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TelephoneRequest req){
        TelephoneResponse res = telephoneService.update(id, req);

        if (res != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        tr.deleteById(id);
    }
}
