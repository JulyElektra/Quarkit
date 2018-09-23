package rc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "CrowdSale")
public class CrowdSale {

    @Id
    String id;

    // Accounts
    User owner;
    List<User> investors = new ArrayList<>();

    Token token;
    Sale sale;

    //Marketing
    String projectName;
    String email;

    //Result info after crowdsale generation
    String crowdSaleAddress;

    public CrowdSale(User owner, Token token, Sale sale, String projectName, String email, String crowdSaleAddress) {
        this.owner = owner;
        investors.add(owner);
        this.token = token;
        this.sale = sale;
        this.projectName = projectName;
        this.email = email;
        this.crowdSaleAddress = crowdSaleAddress;
    }

    public CrowdSale() {

    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getInvestors() {
        return investors;
    }

    public void setInvestors(List<User> investors) {
        this.investors = investors;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCrowdSaleAddress(String crowdSaleAddress) {
        this.crowdSaleAddress = crowdSaleAddress;
    }
}
