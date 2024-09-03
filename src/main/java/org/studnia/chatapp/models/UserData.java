package org.studnia.chatapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserData {
   @Id
   @GeneratedValue
   private long id;
   private String email;

   public void setEmail(String email) {
      this.email = email;
   }

   public long getId() {
      return id;
   }

   public String getEmail() {
      return email;
   }
}
