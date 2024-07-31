package com.hexcode.pro_clock_out.wolibal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hexcode.pro_clock_out.global.domain.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sleep extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleep_id")
    private Long id;

    @Min(0) @Max(100)
    private int score;

    @Min(1) @Max(9)
    private int satisfaction;

    @Min(0) @Max(24)
    private double workdayBedtime;

    @Min(0) @Max(24)
    private double workdayWakeup;

    @Min(0) @Max(24)
    private double dayoffBedtime;

    @Min(0) @Max(24)
    private double dayoffWakeup;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "wolibal_id")
    private Wolibal wolibal;

    public void updateScore(int score) {
        this.score = score;
    }
}
