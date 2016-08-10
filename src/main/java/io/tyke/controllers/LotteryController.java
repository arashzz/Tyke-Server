package io.tyke.controllers;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.tyke.models.Brand;
import io.tyke.models.Lottery;
import io.tyke.models.LotteryBrandForeignDocument;
import io.tyke.repositories.IBaseRepository;
import io.tyke.utility.TykeUtil;

@RestController
@RequestMapping("lottery")
public class LotteryController {
	
	private void seed() throws Exception {

		repository.deleteAll();
		Brand brand = new Brand();
		brand.setName("Nike");
		brandRepository.save(brand);
		
		Lottery lott = new Lottery();
        lott.setId("1");
        lott.setName("jermin");
        LotteryBrandForeignDocument bfd = new LotteryBrandForeignDocument();
        bfd.setName(brand.getName());
        bfd.setId(brand.getId());
        lott.setBrand(bfd);
        repository.save(lott);
	}

	//@Autowired
	//private LotteryRepository repository;
	@Autowired
	private IBaseRepository<Lottery> repository;
	@Autowired
	private IBaseRepository<Brand> brandRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Lottery> search(@RequestParam(value="q") String query) {
		/*try {
			seed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*Reflections reflections = new Reflections("io.tyke.repositories");
		Set<Class<? extends MongoRepository>> subTypes = reflections.getSubTypesOf(MongoRepository.class);
		for(Class<? extends MongoRepository> repo:subTypes){
			for(Type superInterface : repo.getGenericInterfaces()){
				ParameterizedType genericSuperInterface = (ParameterizedType)superInterface;
				System.out.println(genericSuperInterface.getActualTypeArguments()[0]);
			}
		}*/
		Type brandType = TykeUtil.getParentGenericType(LotteryBrandForeignDocument.class);
		IBaseRepository<?> rr;
		try {
			rr = TykeUtil.getRepositoryForType(brandType);
			@SuppressWarnings("unused")
			Object b = rr.findOne("57a9f9ff0e9181e24a47c1e3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //return repository.findByName(query);
		return repository.findAll();
    }

}
