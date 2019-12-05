package domain;

import json.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected ArrayList<Tuple<String, Integer>> exams = new ArrayList<>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        for (Tuple<String, Integer> exam : exams) {
            this.exams.add(exam);
        }
    }

    public JsonObject toJsonObject() {

        JsonPair exs[] = new JsonPair[exams.size()];

        for (int i = 0; i < exams.size(); i++) {
            Tuple<String, Integer> exam = exams.get(i);
            exs[i] = new JsonPair(exam.key, new JsonNumber(exam.value));
        }

        JsonPair exams = new JsonPair("exams",
                new JsonArray(exs));

        JsonObject res = new JsonObject(
                new JsonPair("name", new JsonString(name)),
                new JsonPair("surname", new JsonString(surname)),
                new JsonPair("year", new JsonNumber(year)),
                exams
        );
        return res;
    }
}
