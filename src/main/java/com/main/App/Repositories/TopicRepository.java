package com.main.App.Repositories;

import com.main.App.Models.Topic;
import com.main.App.Projection.TopicProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query(nativeQuery = true, value = "select t.id, t.name from webapp.perfil_topics pt\n" +
            "join webapp.perfils p on p.id = pt.perfil_id\n" +
            "join webapp.topics t on t.id = pt.topic_id\n" +
            "where p.id = :perfilId")
    List<TopicProjection> findTopicsByPerfilId(Long perfilId);
}
