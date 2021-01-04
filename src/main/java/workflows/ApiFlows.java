package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps
{
    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty (String jPath)
    {
        response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Team in Grafana")
    public static void postTeam (String name, String email)
    {
        params.put("name",name);
        params.put("email", email);
        ApiActions.post(params,"/api/teams");
    }

    @Step("Business Flow: Update Existing Team in Grafana")
    public static void updateTeam (String name, String email, String id)
    {
        params.put("name",name);
        params.put("email", email);
        ApiActions.put(params,"/api/teams/"+id);
    }

    @Step("Business Flow: Delete Existing Team in Grafana")
    public static void deleteTeam (String id)
    {
        ApiActions.delete("teams/",id);
    }

    @Step("Business Flow: Create New User in Grafana")
    public static void postUser (String name, String email, String username, String password)
    {
        params.put("name",name);
        params.put("email", email);
        params.put("username", username);
        params.put("password", password);
        ApiActions.post(params,"/api/admin/users");
    }

    @Step("Business Flow: Get User Property")
    public static String getUserProperty (String jPath)
    {
        response = ApiActions.get("/api/users/search");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Delete Existing User in Grafana")
    public static void deleteUser (String id)
    {
        ApiActions.delete("org/users/",id);
    }
}
