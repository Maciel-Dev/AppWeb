package com.main.App.Payload.Response;

import com.main.App.Models.Topic;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilResponse {
    private Long id;
    private String biography;
    private List<Topic> topics;
    private Date creationDate;
    private Long fkUser;
}
