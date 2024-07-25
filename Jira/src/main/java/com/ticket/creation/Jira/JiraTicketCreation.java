package com.ticket.creation.Jira;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class JiraTicketCreation {
    public static void main(String[] args) {
        String jiraUrl = "https://jira.xperi.com";
        String bearerToken = " "; // add bearerToken by taking team help
        RestAssured.baseURI = jiraUrl;
        String jsonPayload = "{"
                + "\"fields\": {"
                + "\"project\": {\"key\": \"METADATA\"},"
                + "\"summary\": \"Creating Jira using Java Task\","
                + "\"description\": \"Written a java code with the help of Rest Assured\","
                + "\"issuetype\": {\"name\": \"Task\"}"
                + "}"
                + "}";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .get("rest/api/2/issue/METADATA-ticketnumber"); // In place of ticketnumber add METADATA-TicketNumber
        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
}
