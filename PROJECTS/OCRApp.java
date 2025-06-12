import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.json.JSONObject;
import okhttp3.*;

public class OCRApp {

    private static final String API_URL = "https://api.aspireocr.com/recognize";
    private static final String API_KEY = "your_api_key_here";

    public static void main(String[] args) {
        try {
            File imageFile = new File("path_to_your_image.jpg");
            String base64Image = encodeFileToBase64(imageFile);
            String jsonResponse = performOCR(base64Image);
            parseAndDisplayResult(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encodeFileToBase64(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }

    private static String performOCR(String base64Image) throws IOException {
        OkHttpClient client = new OkHttpClient();

        JSONObject json = new JSONObject();
        json.put("image", base64Image);

        RequestBody body = RequestBody.create(
            json.toString(), MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
            .url(API_URL)
            .addHeader("Authorization", "Bearer " + API_KEY)
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private static void parseAndDisplayResult(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        String text = jsonObject.getString("recognizedText");
        System.out.println("Recognized Text: " + text);
    }
}
