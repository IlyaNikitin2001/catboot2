package catboot2.service;

import catboot2.domain.Cat;
import catboot2.repository.CatRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Access;
import javax.validation.groups.ConvertGroup;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by USER on 06.11.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatServiceTest {
    @Autowired
CatRepository catRepository;
    @Autowired
    CatService catService;
    Cat cat;
    Cat cat1;
    int id;
    List<Cat> cats;
    @Before
    public void setup(){
        catRepository.deleteAll();
        cat = new Cat();
        cat.setName("cat");
        cat.setPoroda("poroda");
        cat1 = new Cat();
        cat1.setName("cat");
        cat1.setPoroda("poroda");
        cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat);
        catRepository.save(cat);
        catRepository.save(cat1);
        id = catRepository.save(cat).getId();
    }
    @Test
    public void createCat(){
        final Cat catSave = catService.create(cat);
        assertEquals(catSave.getName(), "cat");
        assertEquals(catSave.getPoroda(),"poroda");
    }
    @Test
    public void fetchById(){
        assertEquals(cat, catService.fetchById(id));
    }
    @Test
    public void updateCat(){
        String name = "new Name";
    Cat cat1 = catService.fetchById(id);
    cat1.setName(name);
    catService.updateById(id, cat1);
    assertEquals(name, cat1.getName());
    }
    @Test
    public void deleteById(){
        catService.deleteById(id);
        assertEquals(null, catService.fetchById(id));
    }
    @Test
    public void getCats(){
    List<Cat> cats1 = catService.getAllcats();
    assertEquals(cats1.size(),cats.size());
    }
}