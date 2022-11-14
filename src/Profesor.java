public class Profesor implements Human {

    private String Nume, Prenume, Acronim_Facultate, Materie;
    private Integer Varsta;

    public Profesor(String nume, String prenume, String acronim_Facultate, String materie, Integer varsta) {
        Nume = nume;
        Prenume = prenume;
        Acronim_Facultate = acronim_Facultate;
        Materie = materie;
        Varsta = varsta;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getAcronim_Facultate() {
        return Acronim_Facultate;
    }

    public void setAcronim_Facultate(String acronim_Facultate) {
        Acronim_Facultate = acronim_Facultate;
    }

    public String getMaterie() {
        return Materie;
    }

    public void setMaterie(String materie) {
        Materie = materie;
    }

    public Integer getVarsta() {
        return Varsta;
    }

    public void setVarsta(Integer varsta) {
        Varsta = varsta;
    }

    @Override
    public void greeting(){
        System.out.println("[Prof." + this.Nume + " says Hello!]\n");
    }

    @Override
    public void doWork(){
        System.out.println("[Prof." + this.Nume + " prepares the homework for the Students!]\n");
    }

    @Override
    public String toString(){
        return "[Prof. " + this.Nume + " " + this.Prenume + ", Fac." + this.Acronim_Facultate +
                ", Varsta " + this.Varsta + " de ani, Materia Predata " + this.Materie + ".]\n";
    }

    @Override
    public int compareTo(Human obj){
        return this.getVarsta().compareTo(obj.getVarsta());
    }
}