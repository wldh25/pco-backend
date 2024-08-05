package com.hexcode.pro_clock_out.wolibal.repository;

import com.hexcode.pro_clock_out.wolibal.domain.Rest;
import com.hexcode.pro_clock_out.wolibal.domain.Wolibal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestRepository extends JpaRepository<Rest, Long> {
    Optional<Rest> findByWolibal(Wolibal wolibal);

    @Query("SELECT COUNT(w) FROM Rest w WHERE w.score > :score")
    long countByRestHigherThan(@Param("score") int score);

    @Query("SELECT AVG(w.score) FROM Rest w")
    int getAverageRest();
}
