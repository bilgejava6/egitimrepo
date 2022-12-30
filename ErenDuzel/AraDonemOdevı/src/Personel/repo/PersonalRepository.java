package Personel.repo;

import java.util.List;

import Personel.repository.entity.Personal;
import static Personel.Utility.Utility.*;

public class PersonalRepository implements IPersonal<Personal> {

	@Override
	public void save(Personal personal) {
		personalList.add(personal);

	}

	@Override
	public void update(Personal personal) {
		for(int i=0; i<personalList.size();i++) {
			if(personalList.get(i).getId() == personal.getId()) {
				personalList.set(i, personal);
			}
		}
	}

	@Override
	public void delete(Long id) {
		for(int i=0;i<personalList.size();i++) {
			if(personalList.get(i).getId()== id) {
				personalList.remove(i);
			}
		}

	}

	@Override
	public Personal findById(Long id) {
		for(int i=0;i<personalList.size();i++) {
			if(personalList.get(i).getId()==id) {
				personalList.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Personal> findAll() {
		return personalList;
	}

}
