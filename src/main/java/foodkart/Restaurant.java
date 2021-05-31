package foodkart;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    private int id;
    private String name;
    private List<Integer> pincodeList;

    public Restaurant(int id, String name, List<Integer> pincodeList) {
        this.id = id;
        this.name = name;
        this.pincodeList = pincodeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pincodeList, that.pincodeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pincodeList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPincodeList() {
        return pincodeList;
    }

    public void setPincodeList(List<Integer> pincodeList) {
        this.pincodeList = pincodeList;
    }
}
