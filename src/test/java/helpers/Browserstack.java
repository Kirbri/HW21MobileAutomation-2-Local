package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {
    //curl -u "annakornilova_4DCAWS:QzpReuADTvdMD1ixWDUu" -X GET "https://api.browserstack.com/app-automate/sessions/f3af53a89ec4583b6c59c74579419af5e021827f.json"
    //automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic("annakornilova_4DCAWS", "QzpReuADTvdMD1ixWDUu")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
