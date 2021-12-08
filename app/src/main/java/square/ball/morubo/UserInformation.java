package square.ball.morubo;

public class UserInformation {
    private String nom;
    private String prenom;
    private String numTelephone;
    public UserInformation(){

    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public String getNumTelephone(){
        return this.numTelephone;
    }
    public void setNumTelephone(String numTelephone){
        this.numTelephone=numTelephone;
    }
}
