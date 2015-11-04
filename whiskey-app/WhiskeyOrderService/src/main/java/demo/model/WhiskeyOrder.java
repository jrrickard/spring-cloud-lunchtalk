package demo.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WhiskeyOrder {

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWhiskeyUUID() { return this.whiskeyUUID;}

    public void setWhiskeyUUID(String uuid) {
        this.whiskeyUUID = uuid;
    }

    public void setNumber(Integer number) { this.number = number; }

    public Integer getNumber() { return this.number; }


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String key;

    private String whiskeyUUID;
    private Integer number;




}
