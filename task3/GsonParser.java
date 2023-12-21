import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    public Values parse(String path){
        Gson gson =new Gson();
        try (FileReader reader = new FileReader(path)) {
            Values values = gson.fromJson(reader, Values.class);
            return values;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tests parserTest(String path){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(path)){
            Tests tests = gson.fromJson(reader, Tests.class);
            return tests;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
