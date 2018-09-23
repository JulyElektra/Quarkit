package rc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "CrowdSale")
public class CrowdSale {

    @Id
    String id;

    // Accounts
    User owner;
    Map<User, Integer> investorsToAmount;

    Token token;
    Sale sale;

    //Marketing
    String projectName;
    String email;

    //Result info after crowdsale generation
    String crowdSaleAddress;

    public CrowdSale(User owner, Token token, Sale sale, String projectName, String email, String crowdSaleAddress) {
        this.owner = owner;
        this.token = token;
        this.sale = sale;
        this.projectName = projectName;
        this.email = email;
        this.crowdSaleAddress = crowdSaleAddress;
    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Map<User, Integer> getInvestorsToAmount() {
        return investorsToAmount;
    }

    public Token getToken() {
        return token;
    }

    public Sale getSale() {
        return sale;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getEmail() {
        return email;
    }

    public String getCrowdSaleAddress() {
        return crowdSaleAddress;
    }
}
