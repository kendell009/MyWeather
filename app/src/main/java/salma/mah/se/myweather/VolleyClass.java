package salma.mah.se.myweather;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyClass {

    private MainActivity main;
    private String mURL = "http://api.openweathermap.org/data/2.5/weather?id=2692969&units=metric&appid=0d243700f1782441198dc27b81c5e518";
    public VolleyClass(MainActivity main) {
        this.main = main;
    }
    public void volleyRequest() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(main.getApplicationContext());
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, mURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        main.processAPIData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
