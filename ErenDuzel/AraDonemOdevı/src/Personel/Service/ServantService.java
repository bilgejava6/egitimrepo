package Personel.Service;

import java.util.List;

import Personel.repo.PersonalRepository;
import Personel.repository.entity.Personal;
import Personel.repository.entity.Servant;

public class ServantService {

	private PersonalRepository personalRepository = new PersonalRepository();

	public void save(Servant servant) {
		personalRepository.save(servant);
	}

	public void update(Servant servant) {
		personalRepository.update(servant);
	}

	public void delete(Long id) {
		personalRepository.delete(id);
	}

	public Personal findByID(Long id) {
		return personalRepository.findById(id);
	}

	public List<Personal> findAll() {
		return personalRepository.findAll();
	}
}
