package com.main.App.Controllers;

import com.main.App.Payload.Request.PerfilRequest;
import com.main.App.Payload.Response.PerfilResponse;
import com.main.App.Payload.Response.TelephoneResponse;
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

    @GetMapping("/get/{userId}")
    public ResponseEntity<PerfilResponse> getUserPerfil(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(ps.getPerfilByUser(userId));
    }

    @PostMapping("/post")
    public ResponseEntity<PerfilResponse> create(@RequestBody PerfilRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.create(req));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<PerfilResponse> update(@PathVariable Long id, @RequestBody PerfilRequest req){
        PerfilResponse res = ps.updatePerfil(id, req);

        if (res != null){
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}
