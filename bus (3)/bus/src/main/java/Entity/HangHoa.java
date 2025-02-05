package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HangHoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hanghoaId;

    @ManyToOne
    @JoinColumn(name = "chuyenxe_id")
    private ChuyenXe chuyenXe;

    @Column(nullable = false, length = 255)
    private String tenHangHoa;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal khoiLuongKg;

    @Column(nullable = false, length = 255)
    private String chuHang;

    @Column(nullable = false, length = 15)
    private String soDienThoaiChuHang;

    @Column(nullable = false, length = 255)
    private String diaChiChuHang;
}

