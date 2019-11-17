import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.simple.*;

public class MainApplication {
	
	static String gfyAuthorization(String clientId, String clientSecret) {
		// TODO Auto-generated constructor stub
		
		MainApplication example = new MainApplication();
    	
        String json = "{\"client_id\":\""+clientId+"\",\"client_secret\":\""+clientSecret+"\",\"grant_type\":\"client_credentials\"}";
        
        String response = null;
		try {
			response = example.post("https://api.gfycat.com/v1/oauth/token", json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(response);
        
        JSONObject newJSON = (JSONObject) JSONValue.parse(response);
        
        System.out.println("Authorized with token: "+newJSON.get("access_token"));
        
        return (String) newJSON.get("access_token");
	}
	
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    
    public static String GetJSONValue(String JSONString, String Field)
    {
           return JSONString.substring(JSONString.indexOf(Field), JSONString.indexOf("\n", JSONString.indexOf(Field))).replace(Field+"\": \"", "").replace("\"", "").replace(",","");   
    }

    public static void main(String[] args) throws IOException {
    	MainApplication example = new MainApplication();
    	
    	gfyAuthorization("CLIENT_ID", "CLIENT_SECRET");
    	
    	GfycatAuth uploadUrl = new GfycatAuth();
    	
    	String uploadResponse = uploadUrl.postFromUrl("https://thumbs.gfycat.com/BlushingSpectacularCaudata-mobile.mp4", "Need to test");
    	
    	System.out.println(uploadResponse);
    	
        
        
        
        

        
        

        
        


    }
}