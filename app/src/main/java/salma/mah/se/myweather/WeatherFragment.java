package salma.mah.se.myweather;

import android.app.Fragment;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WeatherFragment extends Fragment {
    private TextView t_Temp, t_Accuracy, t_Timestamp;
    private TextView p_Press, p_Accuracy, p_Timestamp;
    private TextView h_Humid, h_Accuracy, h_Timestamp;
    private TextView apiPressure, apiHumidity, apiTemperature;
    private TextView apiPressureSource, apiHumiditySource, apiTemperatureSource, apiAltitude;
    private Button btnAST, btnVolley;
    private MainActivity main;
    private boolean usingAST, usingVolley;

    public WeatherFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        p_Press = (TextView) view.findViewById(R.id.p_Pressure);
        p_Accuracy = (TextView) view.findViewById(R.id.p_Accuracy);
        p_Timestamp = (TextView) view.findViewById(R.id.p_Timestamp);
        t_Temp = (TextView) view.findViewById(R.id.t_Temp);
        t_Accuracy = (TextView) view.findViewById(R.id.t_Accuracy);
        t_Timestamp = (TextView) view.findViewById(R.id.t_Timestamp);
        h_Humid = (TextView) view.findViewById(R.id.h_Humidity);
        h_Accuracy = (TextView) view.findViewById(R.id.h_Accuracy);
        h_Timestamp = (TextView) view.findViewById(R.id.h_Timestamp);
        apiPressureSource = (TextView) view.findViewById(R.id.p_ASTInfo);
        apiPressure = (TextView) view.findViewById(R.id.p_ASTPressure);
        apiHumiditySource = (TextView) view.findViewById(R.id.h_ASTInfo);
        apiHumidity = (TextView) view.findViewById(R.id.h_ASTHumidity);
        apiTemperatureSource = (TextView) view.findViewById(R.id.t_ASTInfo);
        apiTemperature = (TextView) view.findViewById(R.id.t_ASTTemperature);
        apiAltitude = (TextView) view.findViewById(R.id.tvAltitude);
        main = (MainActivity) getActivity();
        btnAST = (Button) view.findViewById(R.id.btnAST);
        btnAST.setTextColor(getResources().getColor(R.color.AsyncTask));
        btnVolley = (Button) view.findViewById(R.id.btnVolley);
        btnVolley.setTextColor(getResources().getColor(R.color.Volley));
        btnAST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usingVolley = false;
                usingAST = true;
                main.startAST();
            }
        });
        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usingAST = false;
                usingVolley = true;
                main.startVolley();
            }
        });
        return view;
    }
    public void setText(String sensorType, float value, int accuracy, long timestamp) {
        switch (sensorType) {
            case Sensor.STRING_TYPE_PRESSURE:
                p_Press.setText("Pressure: " + String.valueOf(value) + "mBar");
                p_Accuracy.setText("Sensor Accuracy: " + String.valueOf(accuracy));
                p_Timestamp.setText("Timestamp: " + String.valueOf(timestamp));
                break;
            case Sensor.STRING_TYPE_AMBIENT_TEMPERATURE:
                t_Temp.setText("Temperature: " + String.valueOf(value) + "°C");
                t_Accuracy.setText("Sensor Accuracy: " + String.valueOf(accuracy));
                t_Timestamp.setText("Timestamp: " + String.valueOf(timestamp));
                break;
            case Sensor.STRING_TYPE_TEMPERATURE:
                t_Temp.setText("Temperature: " + String.valueOf(value) + "°C");
                t_Accuracy.setText("Sensor Accuracy: " + String.valueOf(accuracy));
                t_Timestamp.setText("Timestamp: " + String.valueOf(timestamp));
                break;
            case Sensor.STRING_TYPE_RELATIVE_HUMIDITY:
                h_Humid.setText("Humidity: " + String.valueOf(value) + "%");
                h_Accuracy.setText("Sensor Accuracy: " + String.valueOf(accuracy));
                h_Timestamp.setText("Timestamp: " + String.valueOf(timestamp));
                break;
            default:
                break;
        }
    }
    public void setAPIText(String pressure, String humidity, String temperature, float altitude) {
        if (usingAST) {
            apiPressureSource.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiPressureSource.setText(getActivity().getString(R.string.data_from_api_with_asynctask));
            apiPressure.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiHumiditySource.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiHumiditySource.setText(getActivity().getString(R.string.data_from_api_with_asynctask));
            apiHumidity.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiTemperatureSource.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiTemperatureSource.setText(getActivity().getString(R.string.data_from_api_with_asynctask));
            apiTemperature.setTextColor(getResources().getColor(R.color.AsyncTask));
            apiAltitude.setTextColor(getResources().getColor(R.color.AsyncTask));
        } else if (usingVolley) {
            apiPressureSource.setTextColor(getResources().getColor(R.color.Volley));
            apiPressureSource.setText(getActivity().getString(R.string.data_from_api_with_volley));
            apiPressure.setTextColor(getResources().getColor(R.color.Volley));
            apiHumiditySource.setTextColor(getResources().getColor(R.color.Volley));
            apiHumiditySource.setText(getActivity().getString(R.string.data_from_api_with_volley));
            apiHumidity.setTextColor(getResources().getColor(R.color.Volley));
            apiTemperatureSource.setTextColor(getResources().getColor(R.color.Volley));
            apiTemperatureSource.setText(getActivity().getString(R.string.data_from_api_with_volley));
            apiTemperature.setTextColor(getResources().getColor(R.color.Volley));
            apiAltitude.setTextColor(getResources().getColor(R.color.Volley));
        }
        apiPressure.setText("Pressure: " + pressure + "mBar");
        apiHumidity.setText("Humidity: " + humidity + "%");
        apiTemperature.setText("Temperature: " + temperature + "°C");
        apiAltitude.setText("Estimated altitude: " + altitude + "m");
    }
}

