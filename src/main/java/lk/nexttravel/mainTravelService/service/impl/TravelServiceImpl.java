package lk.nexttravel.mainTravelService.service.impl;

import lk.nexttravel.mainTravelService.dto.TravelDto;
import lk.nexttravel.mainTravelService.entity.Travel;
import lk.nexttravel.mainTravelService.exception.InvalidException;
import lk.nexttravel.mainTravelService.exception.NotFoundException;
import lk.nexttravel.mainTravelService.repo.TravelRepository;
import lk.nexttravel.mainTravelService.service.TravelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TravelServiceImpl implements TravelService {

    @Autowired
    TravelRepository travelRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveTravel(TravelDto dto) {
        if (!travelRepository.existsById(dto.getPackageId())){
            travelRepository.save(mapper.map(dto, Travel.class));
        }else {
            throw new InvalidException("Id Already Exist");
        }
    }

    @Override
    public void updateTravel(TravelDto dto) {
        if (travelRepository.existsById(dto.getPackageId())){
            travelRepository.save(mapper.map(dto,Travel.class));
        }else {
            throw new NotFoundException("Package not found");
        }

    }

    @Override
    public void deleteTravel(String id) {
        if (travelRepository.existsById(id)){
            travelRepository.deleteById(id);
        }else {
            throw new NotFoundException("Package not found");
        }
    }

    @Override
    public List<TravelDto> getAllTravels() {
        return mapper.map(travelRepository.findAll(), new TypeToken<List<TravelDto>>() {
        }.getType());
    }


    @Override
    public TravelDto searchTravel(String id) {
        return null;
    }
}
