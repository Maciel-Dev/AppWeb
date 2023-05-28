package com.main.App.Controllers;

import com.main.App.Payload.Request.SocialNetworkRequest;
import com.main.App.Payload.Response.SocialNetworkResponse;
import com.main.App.Repositories.SocialNetworkRepository;
import com.main.App.Service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/socialnetwork")
@CrossOrigin
public class SocialNetworkController {
    @Autowired
    SocialNetworkService sws;
    @Autowired
    SocialNetworkRepository snr;

    @GetMapping("/get/{perfilFk}")
    public ResponseEntity<SocialNetworkResponse> getSocialNetworkPerfil(@PathVariable Long perfilFk){
        return ResponseEntity.status(HttpStatus.OK).body(sws.getSocialNetworkByPerfil(perfilFk));
    }

    @PostMapping("/post")
    public ResponseEntity<SocialNetworkResponse> create(@RequestBody SocialNetworkRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(sws.create(req));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<SocialNetworkResponse> update(@PathVariable Long id, @RequestBody SocialNetworkRequest req){
        SocialNetworkResponse res = sws.update(id, req);

        if (res != null){
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        snr.deleteById(id);
    }
}
