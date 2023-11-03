package lk.nexttravel.mainTravelService.service;

import lk.nexttravel.mainTravelService.dto.TravelDto;

import java.util.List;

public interface TravelService {

    void saveTravel(TravelDto dto);
    void updateTravel(TravelDto dto);
    void deleteTravel(String id);
    List<TravelDto> getAllTravels();
    TravelDto searchTravel(String id);
}
