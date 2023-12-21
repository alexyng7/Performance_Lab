import java.util.List;

public class Tests {
    private List <Test> tests;

    @Override
    public String toString() {
        return "Tests{" +
                "tests=" + tests.toString() +
                '}';
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public Tests(List<Test> tests) {
        this.tests = tests;
    }
}
