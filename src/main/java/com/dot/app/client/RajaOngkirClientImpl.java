package com.dot.app.client;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dot.app.model.Cost;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

@Service
public class RajaOngkirClientImpl implements RajaOngkirClient {

	@Value("${com.dot.phone-delivery.url}")
    private String url;
	
	@Value("${com.dot.phone-delivery.apikey}")
    private String apikey;
	
	@Override
	public JSONObject getProvince(int id) {
		JSONObject jsonObject = new JSONObject();
		
		OkHttpClient client = new OkHttpClient();
		url = url.concat("/starter/province");
		url = id != 0 ? (url.concat("/").concat(String.valueOf(id))) : url;
		
		Request request = new Request.Builder().url(url).get().addHeader("key", apikey)
				.build();

		try {
			Response response = client.newCall(request).execute();
			jsonObject = new JSONObject(response.body().string());
		} catch (IOException ex) {
//			            Logger.getLogger(DspClientImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	@Override
	public JSONObject getCity(int id) {
		JSONObject jsonObject = new JSONObject();
		
		OkHttpClient client = new OkHttpClient();
		
		url = url.concat("/starter/city");
		url = id != 0 ? (url.concat("/").concat(String.valueOf(id))) : url;
		
		Request request = new Request.Builder().url(url).get().addHeader("key", apikey)
				.build();

		try {
			Response response = client.newCall(request).execute();
			System.out.println(response);
			jsonObject = new JSONObject(response.body().string());
		} catch (IOException ex) {
//			            Logger.getLogger(DspClientImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	@Override
	public JSONObject getCost(Cost costReqPayload) {
		JSONObject jsonObject = new JSONObject();
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		String origin = String.valueOf(costReqPayload.getOrigin());
		String destination = String.valueOf(costReqPayload.getDestination());
		String weight = String.valueOf(costReqPayload.getWeight());
		String courier = String.valueOf(costReqPayload.getCourier());
		
		url = url.concat("/starter/cost");
		
		RequestBody body = RequestBody.create(mediaType,
				"origin=" + origin + "&destination=" + destination + "&weight=" + weight + "&courier=" + courier);
		Request request = new Request.Builder().url(url).post(body)
				.addHeader("key", apikey)
				.addHeader("content-type", "application/x-www-form-urlencoded").build();

		try {
			Response response = client.newCall(request).execute();
			jsonObject = new JSONObject(response.body().string());
		} catch (IOException ex) {
//			            Logger.getLogger(DspClientImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

}
