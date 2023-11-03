package lk.nexttravel.mainTravelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TravelDto {
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
