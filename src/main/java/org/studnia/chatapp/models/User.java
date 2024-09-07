package org.studnia.chatapp.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "USERS")
public class User {
   @Id
   @NonNull
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;

   @NonNull
   private String email;

   @NonNull
   private String password;

   @Nullable
   private String name;

   @Nullable
   private String phoneNumber;

   public void setEmail(@NonNull String email) {
      this.email = email;
   }

   public void setName(@Nullable String name) { this.name = name; }

   public void setPhoneNumber(@Nullable String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public void setPassword(@NonNull String password) {
      this.password = password;
   }

   public boolean checkPassword(String password) {
      return this.password.equals(password);
   }

   @NonNull
   public String  getId() {
      return id;
   }

   @NonNull
   public String getEmail() {
      return email;
   }

   @Nullable
   public String getName() { return name; }

   @Nullable
   public String getPhoneNumber() { return phoneNumber; }
}
