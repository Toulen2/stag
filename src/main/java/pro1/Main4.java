package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Teacher;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {
        // TODO 4.1: Vypiš do konzole "count" nejkratších učitelských emailových adres
        String json = Api.getTeachersByDepartment(department);
        TeachersList list = new Gson().fromJson(json, TeachersList.class);

        /*List<Teacher> print =*/
        list.items.stream().
                filter(t -> t.email != null).
                sorted(Comparator.comparing(t -> t.email.length())).
                limit(5).
                forEach(p -> System.out.println(p.email));

//        for (Teacher teacher : print) {
//            System.out.println(teacher.email);
//        }
    }
}