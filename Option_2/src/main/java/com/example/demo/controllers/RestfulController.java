package com.example.demo.controllers;

import com.example.demo.helper.Alerts;
import com.example.demo.helper.SampleGenerator;
import com.example.demo.helper.SolrSamplePathHelper;
import com.example.demo.models.Sample;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;


@RestController
public class RestfulController {
    RestTemplate restTemplate = new RestTemplate();
    SolrSamplePathHelper solrSamplePathHelper = new SolrSamplePathHelper();
    //Linked list to store alerts
    Alerts alerts = new Alerts();

    //Add sample to solr index
    @RequestMapping(value = "/add")
    public String addSampleObject(){
        //Create new sample object
        Sample sample = SampleGenerator.createRandomSampleObject(20);
        //Set header media type to  json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(sample.toJSON() ,headers);
        //Add object to solr index
        restTemplate.postForObject(solrSamplePathHelper.getSolrPostPath("json"), entity, String.class);
        //Add the new sample to the alerts list
        alerts.getRecentlyChangedItems().add("ADDED: " + sample.toJSON());
        //Return json format of object for clarification
        return sample.toJSON();
    }

    //Delete sample from solr index
    @RequestMapping(value = "/delete/{id}")
    public String deleteSampleObject(@PathVariable("id") int id) throws IOException {
        //Check to see if sample with id exists in solr index
        String response = restTemplate.getForObject(solrSamplePathHelper.getSolrSelectPath(id, "csv"), String.class);
        String responseData[] = response.split(",");
        //If it does, then delete it
        if(responseData.length > 5){
            restTemplate.getForObject(solrSamplePathHelper.getSolrDeleteByIdPath(id), String.class);
            alerts.getRecentlyChangedItems().add("DELETED: object with id:" + id);
        }
        //Return csv format of response for clarification
        return response;
    }

    //Path for getting the latest updates
    @RequestMapping(value = "/getLatestAlert", method = RequestMethod.GET)
    public String getLatestAlert(){
        //Default value for update message
        String latestSampleChange = "";
        //Try to get the latest message if it exists
        try {
            latestSampleChange = alerts.getRecentlyChangedItems().get(0);
            alerts.getRecentlyChangedItems().remove(0);
        } catch (IndexOutOfBoundsException e){}
        //Return the message/alert
        return latestSampleChange;
    }

}
