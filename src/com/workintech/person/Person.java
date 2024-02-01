package com.workintech.person;

import java.util.Objects;

public class Person {
    private String name;
private int position;
    public Person(String name,int position) {
        this.name = name;
        this.position=position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void whoYouAre(int position){
      if(position==0){
          System.out.println("Kişi bir yazardır.");
     } else if (position==1) {
          System.out.println("Kişi bir okuyucudur");
      }
      else {
          System.out.println("Lüffen geçerli pozisyon numarasını giriniz!! (0 veya 1)");
      }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
