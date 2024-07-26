package com.hexcode.pro_clock_out.member.domain;

import com.hexcode.pro_clock_out.global.domain.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @NotEmpty
    private String role;

    private String nickname;

    @Column(length = 1000)
    private String photoUrl;

    @ElementCollection(targetClass = Lifestyle.class)
    @CollectionTable(name = "member_life_styles", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "life_style")
    @Enumerated(EnumType.STRING)
    private List<Lifestyle> life;

    public void updatePhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateLife(List<Lifestyle> life) {
        this.life = life;
    }
}
