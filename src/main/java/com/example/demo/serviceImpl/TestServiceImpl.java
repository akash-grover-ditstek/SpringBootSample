package com.example.demo.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.example.demo.payload.TestDTO;
import com.example.demo.service.TestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public ResponseEntity<Object> uniqueText(TestDTO input) {
        JSONObject entity = new JSONObject();
        try {
            InputStream inputStream;
            String allWords[];
            inputStream = input.getFile().getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String rawText = br.lines().collect(Collectors.joining(":"));
            allWords = rawText.split("[ :,.]");
            Set<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
            set.addAll(Arrays.asList(allWords));
            set.removeAll(Arrays.asList(""," ",null));
            entity.put("result", set);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>(entity, HttpStatus.OK);
    }

}
