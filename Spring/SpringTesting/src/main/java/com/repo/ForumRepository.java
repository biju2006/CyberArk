package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.repo.beans.Forum;

public interface ForumRepository extends JpaRepository<Forum,Long>{
}
