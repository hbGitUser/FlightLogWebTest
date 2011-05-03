package flightLog.entities;

import java.util.Calendar;

public class Flight {
   private Integer number;
   private Calendar dateTof;
   private Calendar dateTdn;
   private String sailplaneModel;
   private String sailplaneRegistration;
   // private Sailplane sailplane;
   private Pilot pilot;
   // private Companion companion;
   private String companion;
   private String tofType;
   // private Location locationTof;
   private String locationTof;
   // private Location locationTdn;
   private String locationTdn;
   private String remarks;

   public Flight() {
   }

   public Integer getNumber() {
      return number;
   }

   public void setNumber(Integer number) {
      this.number = number;
   }

   public Calendar getDateTof() {
      return dateTof;
   }

   public void setDateTof(Calendar dateTof) {
      this.dateTof = dateTof;
   }

   public Calendar getDateTdn() {
      return dateTdn;
   }

   public void setDateTdn(Calendar dateTdn) {
      this.dateTdn = dateTdn;
   }

   // public Sailplane getSailplane() {
   // return sailplane;
   // }
   //
   // public void setSailplane(Sailplane sailplane) {
   // this.sailplane = sailplane;
   // }
   //
   // public Sailplane getSailplane() {
   // return sailplane;
   // }

   public void setSailplaneModel(String model) {
      this.sailplaneModel = model;
   }

   public String getSailplaneModel() {
      return sailplaneModel;
   }

   public void setSailplaneRegistration(String registration) {
      this.sailplaneRegistration = registration;
   }

   public String getSailplaneRegistration() {
      return sailplaneRegistration;
   }

   public Pilot getPilot() {
      return pilot;
   }

   public void setPilot(Pilot pilot) {
      this.pilot = pilot;
   }

   // public Companion getCompanion() {
   // return companion;
   // }
   //
   // public void setCompanion(Companion companion) {
   // this.companion = companion;
   // }

   public String getCompanion() {
      return companion;
   }

   public void setCompanion(String companion) {
      this.companion = companion;
   }

   public String getTofType() {
      return tofType;
   }

   public void setTofType(String tofType) {
      this.tofType = tofType;
   }

   // public Location getLocationTof() {
   // return locationTof;
   // }
   //
   // public void setLocationTof(Location locationTof) {
   // this.locationTof = locationTof;
   // }

   public String getLocationTof() {
      return locationTof;
   }

   public void setLocationTof(String locationTof) {
      this.locationTof = locationTof;
   }

   // public Location getLocationTdn() {
   // return locationTdn;
   // }
   //
   // public void setLocationTdn(Location locationTdn) {
   // this.locationTdn = locationTdn;
   // }

   public String getLocationTdn() {
      return locationTdn;
   }

   public void setLocationTdn(String locationTdn) {
      this.locationTdn = locationTdn;
   }

   public String getRemarks() {
      return remarks;
   }

   public void setRemarks(String remarks) {
      this.remarks = remarks;
   }
}
