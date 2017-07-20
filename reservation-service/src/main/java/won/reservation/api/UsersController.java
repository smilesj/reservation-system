package won.reservation.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/users")
public class UsersController {
	static final String CLIENT_ID = "7HYSSZyvxLo0lyAcabtI";
	static final String CLIENT_SECRET = "f4xa_X8CdI";
		
	@GetMapping
	public String getUrl(HttpSession session) {
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + CLIENT_ID;
		apiURL += "&redirect_uri=" + "http://localhost:8080/api/users/loginCallBack";
		apiURL += "&state=" + state;
		session.setAttribute("state", state);
		return "redirect:"+apiURL;
	}
	

	@GetMapping("/loginCallBack")
	public String test(HttpServletRequest req, HttpSession session) {
		// 세션값을 비교하는 것 하기
		//RESTTemplate
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		
		if(session.getAttribute("state").equals(state)) {
			try {
				String redirectURI = URLEncoder.encode("/api/users/loginCallBack", "UTF-8");
				String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
				apiURL += "client_id=" + CLIENT_ID;
				apiURL += "&client_secret=" + CLIENT_SECRET;
				apiURL += "&redirect_uri=" + redirectURI;
				apiURL += "&code=" + code;
				apiURL += "&state=" + state;
				
				 String access_token = "";
				 String refresh_token = "";
				 
				 URL url = new URL(apiURL);
				 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				 conn.setRequestMethod("GET");
				 int responseCode = conn.getResponseCode();
				 BufferedReader br;
				 if(responseCode == 200) {
					 br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				 } else {
					 br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				 }
				 String inputLine;
				 while ((inputLine = br.readLine()) != null) {
					 System.out.println(inputLine);
				 }
				 
				 session.setAttribute("loginStatus", "success");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "redirect:/myreservation";
		}else {
			return "redirect:/";
		}
	}
}
