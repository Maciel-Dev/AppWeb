package com.main.App.Controllers;

import com.main.App.Payload.Request.PerfilRequest;
import com.main.App.Payload.Response.PerfilResponse;
import com.main.App.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/perfil")
@CrossOrigin
public class PerfilController {
    @Autowired
    private PerfilService ps;

    @PostMapping("/post")
    public ResponseEntity<PerfilResponse> add(@RequestBody PerfilRequest pr){
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.create(pr));
    }
}
