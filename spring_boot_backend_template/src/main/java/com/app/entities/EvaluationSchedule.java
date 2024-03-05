package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "evaluation_schedule")
public class EvaluationSchedule extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject; // Foreign key reference to Subject
	private String evaluationType; // e.g., "Theory", "Lab", "IA1", "IA2"
	private LocalDateTime validTill;
	private String groupvalue;
	private Long assignedUserId;
	public void setApproved(boolean b) {
		
	}

}
