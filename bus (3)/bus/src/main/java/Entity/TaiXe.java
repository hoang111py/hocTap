package Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taixeId;

    @Column(nullable = false, length = 100)
    private String tenTaixe;

    @Column(nullable = false, unique = true, length = 15)
    private String soDienThoai;
}
