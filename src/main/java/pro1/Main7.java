package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Deadline;
import pro1.apiDataModel.Specialization;
import pro1.apiDataModel.SpecializationsList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main7 {

    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }

    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        SpecializationsList specializationsList = new Gson().fromJson(json, SpecializationsList.class);

        SimpleDateFormat parser = new SimpleDateFormat("d.M.yyyy");

        String specializationDeadline = specializationsList.
                items.
                stream().
                filter(r -> r != null && r.DeadlinePrihlaska != null && r.DeadlinePrihlaska.value != null).
                map(a -> a.DeadlinePrihlaska.value).         // (String t) -> Tnteger.parseInt(t)
                distinct().
                sorted((a, b) -> {
                    try {                           // try/catch pro parser
                        return parser.parse(a).compareTo(parser.parse(b));
                    } catch (ParseException e) {
                        throw new RuntimeException();
                    }
                }).
                collect(Collectors.joining(","));

        return specializationDeadline;

    }
}
