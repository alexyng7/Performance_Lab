import java.util.List;

public class Values {
    private List<Test> values;

    public Values(){

    }

    public Values(List<Test> values) {
        this.values = values;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Values{" +
                "values=" + values.toString() +
                '}';
    }
}
