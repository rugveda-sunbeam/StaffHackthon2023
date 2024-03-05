package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluationScheduleDTO {
    private Long subjectId; // Foreign key reference to Subject
	private String evaluationType; // e.g., "Theory", "Lab", "IA1", "IA2"
	private LocalDateTime validTill;
	private String groupvalue;
	private Long assignedUserId;

}
