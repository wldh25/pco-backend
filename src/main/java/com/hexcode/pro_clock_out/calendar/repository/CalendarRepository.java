package com.hexcode.pro_clock_out.calendar.repository;

import com.hexcode.pro_clock_out.calendar.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
