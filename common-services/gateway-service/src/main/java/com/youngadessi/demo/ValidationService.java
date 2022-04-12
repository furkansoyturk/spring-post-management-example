package com.youngadessi.demo;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ValidationService {

    public int validate(String jwtToken) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");

        Request request = new Request.Builder()
                .url("http://localhost:8085/auth-service/validate")
                .method("POST", body)
                .addHeader("Authorization",jwtToken)
                .build();
        Response response = client.newCall(request).execute();

        return response.code();
    }

}
