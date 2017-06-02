package com.example.demo.helper;

import com.example.demo.models.Sample;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class SampleGenerator {
    //Generate a sample object with random values
    public static Sample createRandomSampleObject(int idRange){
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();
        Integer id = random.nextInt(idRange);
        String title  = new BigInteger(130, secureRandom).toString(32);
        String author  = new BigInteger(130, secureRandom).toString(32);
        String text  = new BigInteger(130, secureRandom).toString(32);
        String fullText  = new BigInteger(130, secureRandom).toString(32);
        return new Sample(id, title, author, text, fullText);
    }
}
