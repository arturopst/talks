package com.aca.talks.repository;

import com.aca.talks.com.aca.talks.domain.Talk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalkRepository extends JpaRepository<Talk, Long> {
}
