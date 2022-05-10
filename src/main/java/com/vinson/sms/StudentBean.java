package com.vinson.sms;

public class StudentBean {
    String name;
    int regno;
    String phno;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhno(){
        return phno;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public void setPhno(String phno){
        this.phno = phno;
    }
}
