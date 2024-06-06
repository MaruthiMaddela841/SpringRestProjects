package in.ineuron.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristByDetails(Tourist tourist);
	public String updateTouristById(Integer id,Float hikePercentage);
	public String deleteTouristById(Integer id);
}
