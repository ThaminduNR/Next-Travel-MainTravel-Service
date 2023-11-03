package lk.nexttravel.mainTravelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Travel {
    @Id
    private String packageId;
    private String category;
    private String startDate;
    private String endDate;
    private String travelArea;
    private int totalHeadCount;
    private int packageValue;
    private double paidValue;
    private String customerId;
    private String vehicleId;
    private String hotelId;
    private String guideId;

}
