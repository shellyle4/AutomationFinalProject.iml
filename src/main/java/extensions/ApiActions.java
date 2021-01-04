package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps
{
    @Step("Get Date From Server")
    public static Response get (String paramValues)
    {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
    }

    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    @Step("Delete Data from Server")
    public static void delete(String path, String id)
    {
        //response = httpRequest.delete("/api/teams/"+id);
        response = httpRequest.delete("/api/"+path+id);
    }
}
