public class userInfoMODEL {
   static String name,Class,address,departuredate,returndate,airlines;
   static String nationality="Pakistan";
   static int no_seats;

    void setName(String n){
        name=n;
    }
    void setNationality(String n){
        nationality=n;
    }
    void setClass(String n){Class =n;}
    void setAddress(String n){address = n;}
    void setDeparturedate(String n){
        departuredate=n;
    }
    void setReturndate(String n){returndate=n;}
    void setNo_seats(int n){no_seats=n;}

    String getName(){
        return name;
    }
    String getNationality(){
        return nationality;
    }
    String getClasstype(){
        return Class;
    }
    String getAddress(){
        return address;
    }
    String getDeparturedate(){
        return departuredate;
    }
    String getReturndate(){
        return returndate;
    }
    int getAge(){return no_seats;}
}
