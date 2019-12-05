package json;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private final ArrayList<JsonPair> Objs = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair js : jsonPairs) {
            Objs.add(js);
        }
    }

    @Override
    public String toJson() {
        String res = "{";
        if (Objs.size() != 0) {
            for (JsonPair jsPair : Objs) {
                if (res.length() > 1) {res += ", ";}
                res += "'" + jsPair.key + "': " +
                        jsPair.value.toJson();
            }
            res += "}";
            return res;
        }
        return "{}";
    }

    public void add(JsonPair jsonPair) {
        Objs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair obj : Objs) {
            if (obj.key == name) {
                return obj.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject res = new JsonObject();
        for (String name : names) {
            for (JsonPair pair : Objs) {
                if (name == pair.key) {
                    res.add(pair);
                }
            }
        }
        return res;
    }
}
