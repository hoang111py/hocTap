package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuNhapLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lichsuId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate ngayNhap;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String noiDung;
}

