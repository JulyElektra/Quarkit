package rc;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return getCrowdsaleById(id);
    }

    @PostMapping("")
    public CrowdSale insertCrowdSale(@RequestBody CrowdSale crowdSale) {
        return crowdSaleRepository.save(crowdSale);
    }


    @GetMapping("/{crowdsaleId}/users/all")
    public List<User> getAllUsers(@PathVariable String crowdsaleId) {
        return getCrowdsaleById(crowdsaleId).investors;
    }

    @GetMapping("/{crowdsaleId}/users/{id}")
    public User getUsersById(@PathVariable String crowdsaleId, @PathVariable("id") String id) {
        return getCrowdsaleById(crowdsaleId).investors.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    @PostMapping("/{crowdsaleId}/users")
    public CrowdSale insertUser(@PathVariable String crowdsaleId, @RequestBody User user) {
        CrowdSale crowdSale = getCrowdsaleById(crowdsaleId);
        crowdSale.investors.add(user);
        return crowdSaleRepository.save(crowdSale);
    }

    @PostMapping("/{crowdsaleId}/users/authorization")
    public boolean isApproved(@PathVariable String crowdsaleId, @RequestBody Map<String, String> json) {
        String userId = json.get("id");
        String userPassword = json.get("password");
        User userFound = null;
        List<User> investors = getCrowdsaleById(crowdsaleId).investors;
        if (!investors.isEmpty()) {
            userFound = investors.stream().filter(u -> u.id.equals(userId) && BCrypt.checkpw(userPassword, u.password)).findFirst().orElse(null);
        }

        if (userFound != null) {
            return true;
        }
        return false;
    }

    private CrowdSale getCrowdsaleById(String crowdsaleId){
        CrowdSale foundCrowdSale = crowdSaleRepository.findById(crowdsaleId).orElse(null);
        if (foundCrowdSale == null) {
            String msg = "Crowdsale with the id=" + crowdsaleId + " is not found.";
            System.out.println(msg);
            throw new IllegalArgumentException(msg);
        }
        return foundCrowdSale;
    }
}