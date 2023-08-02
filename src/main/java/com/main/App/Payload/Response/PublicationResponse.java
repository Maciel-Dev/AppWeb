package com.main.App.Payload.Response;

import com.main.App.Models.Comment;
import com.main.App.Models.Publication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicationResponse {
    Publication publication;
    private String username;

}
