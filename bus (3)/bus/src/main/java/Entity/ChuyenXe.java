package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chuyenxeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoaiXe loaiXe;

    @Column(nullable = false)
    private LocalDate ngayXuatPhat;

    @Column(nullable = false)
    private LocalTime gioXuatPhat;

    @Column(nullable = false, length = 255)
    private String diemDi;

    @Column(nullable = false, length = 255)
    private String diemDen;

    @ManyToOne
    @JoinColumn(name = "taixe_id")
    private TaiXe taiXe;

    public enum LoaiXe {
        XeKhach, XeTai
    }
}

