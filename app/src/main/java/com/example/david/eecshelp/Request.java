package com.example.david.eecshelp;

import java.io.Serializable;

/**
 * Created by David on 3/24/2015.
 */
public class Request implements Serializable {
    String location;
    String name;
    String timestamp;
    String email;
    String issue;

    String getLocation(){
        return location;
    }
    void setLocation(String _location){
        location = _location;
    }

    String getName(){
        return name;
    }
    void setName(String _name){
        name = _name;
    }

    String getTimestamp(){
        return timestamp;
    }
    void setTimestamp(String _timestamp) {
        timestamp = _timestamp;
    }

    String getEmail(){
        return email;
    }
    void setEmail(String _email){
        email = _email;
    }

    String getIssue(){
        return issue;
    }
    void setIssue(String _issue){
        issue = _issue;
    }

    Request(String _location,String _name, String _timestamp,String _email,String _issue) {
        location = _location;
        name = _name;
        timestamp = _timestamp;
        email = _email;
        issue = _issue;
    }
    @Override public String toString(){
        return location + " " + name + " " + timestamp;
    }
}
