package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main5 {

    public static void main(String[] args) {
        System.out.println(roomsSummary("KIKM",2024));
    }

    public static String roomsSummary(String department, int year)
    {
        String json = Api.getActionsByDepartment(department, year);
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        String result = actions.items.stream()
                .map(a -> a.room)
                .filter(r -> r != null /*&& !r.equals(null)*/)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));  // map - nemám už spoustu rozvrhových akcí, ale spoustu řetězců

        return result; // TODO 5.1: Vrať výpis učeben, které katedra v daném roce využila (seřadit abecedně, oddělit čárkou)
    }
}