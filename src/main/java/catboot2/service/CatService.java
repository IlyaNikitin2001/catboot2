package catboot2.service;

import catboot2.domain.Cat;
import catboot2.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 06.11.2017.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatService {
    @Autowired
CatRepository catRepository;
    public Cat create(Cat cat) {
    return catRepository.save(cat);
    }

    public Cat fetchById(int id) {
        return catRepository.findOne(id);
    }

    public Cat updateById(int id, Cat cat1) {
        final Cat catUpdate = fetchById(id);
        catRepository.updateCat(id, cat1.getName(), cat1.getPoroda());
        return fetchById(id);

    }

    public void deleteById(int id) {
     catRepository.delete(id);
    }

    public List<Cat> getAllcats() {
        return (List<Cat>) catRepository.findAll();
    }
}
