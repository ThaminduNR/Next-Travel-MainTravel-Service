package lk.nexttravel.mainTravelService.controller;

import lk.nexttravel.mainTravelService.dto.TravelDto;
import lk.nexttravel.mainTravelService.service.TravelService;
import lk.nexttravel.mainTravelService.util.IdGenerator;
import lk.nexttravel.mainTravelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nexttravel/travel/service")
@CrossOrigin
public class MainTravelController {

    @Autowired
    TravelService travelService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTravel(@RequestBody TravelDto dto){
        IdGenerator idGenerator = new IdGenerator();
        String packageId = idGenerator.generateID();

        dto.setPackageId(packageId);
        travelService.saveTravel(dto);

        return new ResponseUtil(200,"saved",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTravel(@RequestBody TravelDto dto){

        travelService.updateTravel(dto);
        return new ResponseUtil(200,"Update success",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllTravel(){
        List<TravelDto> allTravels = travelService.getAllTravels();
        return new ResponseUtil(200,"Get all",allTravels);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteTravel(@RequestParam String id){
        travelService.deleteTravel(id);
        return new ResponseUtil(200,"Delete Success",null);
    }


    @GetMapping(path = {"/id"})
    public ResponseUtil searchTravel(@PathVariable String id){
        return null;
    }
}
