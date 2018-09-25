package rc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crowdsales")
public class CrowdSaleController {
    CrowdSaleRepository crowdSaleRepository;

    public CrowdSaleController(CrowdSaleRepository crowdSaleRepository) {
        this.crowdSaleRepository = crowdSaleRepository;
    }

    @GetMapping("/all")
    public List<CrowdSale> getAll() {
        return crowdSaleRepository.findAll();
    }

    @GetMapping("/{id}")
    public CrowdSale getById(@PathVariable("id") String id) {
        return crowdSaleRepository.findById(id).get();
    }

    @PostMapping("")
    public CrowdSale insertCrowdSale(@RequestBody CrowdSale crowdSale) {
        return crowdSaleRepository.save(crowdSale);
    }


    @GetMapping("/{crowdsaleId}/users/all")
    public List<User> getAllUsers(@PathVariable String crowdsaleId) {
        return crowdSaleRepository.findById(crowdsaleId).get().investors;
    }

    @GetMapping("/{crowdsaleId}/users/{id}")
    public User getUsersById(@PathVariable String crowdsaleId, @PathVariable("id") String id) {
        return crowdSaleRepository.findById(crowdsaleId).get().investors.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    @PostMapping("/{crowdsaleId}/users")
    public CrowdSale insertUser(@PathVariable String crowdsaleId, @RequestBody User user) {
        CrowdSale crowdSale = crowdSaleRepository.findById(crowdsaleId).get();
        crowdSale.investors.add(user);
        return crowdSaleRepository.save(crowdSale);
    }

    @PostMapping("/{crowdsaleId}/users/authorization")
    public boolean isApproved(@PathVariable String crowdsaleId, @RequestBody User user) {
        User userFound = null;
        List<User> investors = crowdSaleRepository.findById(crowdsaleId).get().investors;
        if (!investors.isEmpty()) {
            userFound = investors.stream().filter(u -> u.id.equals(user.id) && u.password.equals(user.password)).findFirst().orElse(null);
        }

        if (userFound != null) {
            return true;
        }
        return false;
    }
}