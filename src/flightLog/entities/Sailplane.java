package flightLog.entities;

public class Sailplane {
   private String model;
   private String registration;

   public Sailplane(String model, String registration) {
      this.model = model;
      this.registration = registration;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getRegistration() {
      return registration;
   }

   public void setRegistration(String registration) {
      this.registration = registration;
   }
}
