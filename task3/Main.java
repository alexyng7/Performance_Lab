import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GsonParser parser = new GsonParser();
        Values values = parser.parse(args[0]);
        //System.out.println(values.toString());
        Tests tests = parser.parserTest(args[1]);
        //System.out.println(tests.getTests().toString());

        //System.out.println(getValue(values, 41));
        addValue(tests.getTests(),values);
        //System.out.println(tests.getTests().toString());
        getResultJson(tests);


    }

    public static String getValue(Values values, long id){
        for (Test t : values.getValues()) {
            if(t.getId()==id){
                return t.getValue();
            }
        }
        return null;
    }

    public static void addValue (List<Test> tests, Values values){
        for (Test t: tests) {
            if(t.getValues() == null) {
                long id = t.getId();
                String st = getValue(values, id);
                t.setValue(st);
            } else {
                long id = t.getId();
                String st = getValue(values, id);
                t.setValue(st);
                addValue(t.getValues(), values);
            }

        }

    }
    private static void getResultJson(Tests tests){
        try(FileWriter writer = new FileWriter("report.json")){
            Gson gson = new Gson();
            writer.write(gson.toJson(tests.getTests()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }



}
