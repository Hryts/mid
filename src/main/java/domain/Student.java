package domain;

import json.*;

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
        JsonObject res = toJsonObject();
        return null;
    }
}
