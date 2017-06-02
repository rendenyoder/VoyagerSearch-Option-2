package com.example.demo.helper;

public class SolrSamplePathHelper {
    //Get path for adding to solr index
    public String getSolrPostPath(String type) {
        return "http://localhost:8983/solr/sample/update?commit=true&wt=" + type;
    }
    //Get path for deleting from solr by id
    public String getSolrDeleteByIdPath(int id){
        return "http://localhost:8983/solr/sample/update?stream.body=<delete><query>id:"+
                id + "</query></delete>&commit=true";
    }
    //Get path for selecting from solr
    public String getSolrSelectPath(int id, String type){
        return "http://localhost:8983/solr/sample/select?indent=on&q=" + id + "&wt=" + type;
    }

}
