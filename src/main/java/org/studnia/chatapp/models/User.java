package org.studnia.chatapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
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
