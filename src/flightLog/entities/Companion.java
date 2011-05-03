package flightLog.entities;

public class Companion {
   private String surname;
   private String forename;
   // Lehrer, Navigator, Passagier, Prüfer
   private String compType;

   public Companion(String surname, String forename, String compType) {
      this.surname = surname;
      this.forename = forename;
      this.compType = compType;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getForename() {
      return forename;
   }

   public void setForename(String forename) {
      this.forename = forename;
   }

   public String getCompType() {
      return compType;
   }

   public void setCompType(String compType) {
      this.compType = compType;
   }
}
