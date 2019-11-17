import java.io.IOException;
import org.json.simple.*;

public class GfycatAuth {
	
	 String postFromUrl(String url, String title) throws IOException {
		
		MainApplication example = new MainApplication();
		
		String jsonPost = "{\"fetchUrl\":\""+url+"\",\"title\":\""+title+"\",\"noMd5 \":\"true\"}";
	        
	    String responsePost = example.post("https://api.gfycat.com/v1/gfycats", jsonPost);
	    System.out.println(responsePost);
	        
	    JSONObject newJSONGfy = (JSONObject) JSONValue.parse(responsePost);
	    String gfyName = newJSONGfy.get("gfyname").toString();
	    
		return gfyName;
	}

}