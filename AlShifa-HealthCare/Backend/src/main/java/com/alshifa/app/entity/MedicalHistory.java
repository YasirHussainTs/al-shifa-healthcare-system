package com.alshifa.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String diagnosis;

    @Column(name = "date_of_record", nullable = false)
    private LocalDateTime dateOfRecord;

    // Many medical histories can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key column in medical_history table
    private User user;

    private String notes;


}
