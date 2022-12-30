package Personel.Service;

import java.util.List;

import Personel.repo.PersonalRepository;
import Personel.repository.entity.Personal;

public class PersonalService {

	private final PersonalRepository personalRepository;
	
	public PersonalService() {
		this.personalRepository= new PersonalRepository();
	}
	
	public void save(Personal personal) {
		personalRepository.save(personal);
	}
	public void update(Personal personal) {
		personalRepository.update(personal);
	}
	public void delete(Long id) {
		personalRepository.delete(id);
	}
	public Personal findById(Long id) {
		return personalRepository.findById(id);
	}
	public List<Personal> findAll(){
		return personalRepository.findAll();
	}
}
