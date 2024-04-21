package com.backend.programming.learning.system.core.service.domain.implement.calendarevent;

import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.exception.CalendarEventNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventDeleteHelper {
    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventDeleteHelper(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @Transactional
    public void deleteCalendarEventById(UUID calendarEventId) {
        checkCalendarEventExists(calendarEventId);
        calendarEventRepository.deleteCalendarEvent(calendarEventId);
    }

    private void checkCalendarEventExists(UUID calendarEventId) {
        Optional<CalendarEvent> calendarEvent = calendarEventRepository.findById(calendarEventId);
        if (calendarEvent.isEmpty()) {
            log.warn("Could not find calendar event with id: {}", calendarEventId);
            throw new ChapterNotFoundException("Could not find calendar event with id: " + calendarEventId);
        }
    }
}





















