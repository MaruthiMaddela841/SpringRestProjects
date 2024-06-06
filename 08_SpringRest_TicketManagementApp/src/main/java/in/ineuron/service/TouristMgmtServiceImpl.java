package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService{
	
	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid=repo.save(tourist).getTid();
		return "Tourist is registered with ID::"+tid;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
//		Optional<Tourist> optional = repo.findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		else
//			throw new TouristNotFoundException(id+":: Record not found");
		
		return repo.findById(id)
				.orElseThrow(()->new TouristNotFoundException(id+":: Record not found"));
	}

	@Override
	public String updateTouristByDetails(Tourist tourist) {
		Optional<Tourist> optional = repo.findById(tourist.getTid());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist record with ID::"+tourist.getTid()+" is Updated";
		}
		else {
			throw new TouristNotFoundException("Record not found with ID::"+tourist.getTid());
		}

	}

	@Override
	public String updateTouristById(Integer id, Float hikePercentage) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist=optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercentage/100)));
			repo.save(tourist);
			return "Tourist record with ID::"+tourist.getTid()+" is Updated";
		}
		else {
			throw new TouristNotFoundException("Record not found");
		}
		
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist=optional.get();
			repo.delete(tourist);
			return "Tourist with ID::"+id+" is deleted";
		}
		else {
			throw new TouristNotFoundException("Record not found");
		}
	}
	

}
