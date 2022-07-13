package model;


import java.io.Serializable;


public class Member implements Serializable {
    private int id;
    private String name;

    public Member(int id,String name){
        this.id=id;
        this.name=name;
    }

    public java.lang.String toString() {
        return "Member{id="+id+" member="+name+'}';
    }
}
