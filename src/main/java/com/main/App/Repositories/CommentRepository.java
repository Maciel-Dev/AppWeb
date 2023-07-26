package com.main.App.Repositories;

import com.main.App.Models.Comment;
import com.main.App.Models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    List<Comment> findByPublicationsId(Long postId);
}
