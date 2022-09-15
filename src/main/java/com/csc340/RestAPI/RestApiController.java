package com.csc340.RestAPI;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestApiController {

   
    @GetMapping("/jokes")
    public Object getJoke() {
        String url = "https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate = new RestTemplate();
        Object RandJoke = restTemplate.getForObject(url, Object.class);
        
        //print response to console
        String Joke = restTemplate.getForObject(url, String.class);

        //parse revelent info from response
        JSONObject jo = new JSONObject(Joke);
        System.out.println(jo.toString());
        String setup = jo.getString("setup");
        String punchLine = jo.getString("punchline");
        System.out.println(setup);
        System.out.println(punchLine);

        return RandJoke;
    }

    
}
