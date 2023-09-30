package Services;

import DAO.AnimalDAO;
import Model.Animal;

import java.util.*;

public interface AnimalService {

    void createOrUpdateAnimal(AnimalDAO animalDAO);

    List<Animal> getAllAnimal();

    void deleteAnimal(Long id);

    AnimalDAO editAnimal(Long id);

    List<AnimalDAO> getAnimalsById(Long id);

}
