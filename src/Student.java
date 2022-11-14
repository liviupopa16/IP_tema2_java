public class Student implements Human {

    private String Nume, Prenume, Acronim_Facultate;
    private Integer Varsta, An_De_Studiu;

    public Student(String nume, String prenume, String acronim_Facultate, Integer varsta, Integer an_De_Studiu) {
        Nume = nume;
        Prenume = prenume;
        Acronim_Facultate = acronim_Facultate;
        Varsta = varsta;
        An_De_Studiu = an_De_Studiu;
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

    public Integer getVarsta() {
        return Varsta;
    }

    public void setVarsta(Integer varsta) {
        Varsta = varsta;
    }

    public Integer getAn_De_Studiu() {
        return An_De_Studiu;
    }

    public void setAn_De_Studiu(Integer an_De_Studiu) {
        An_De_Studiu = an_De_Studiu;
    }

    @Override
    public void greeting(){
        System.out.println("[Sd." + this.Nume + " says Hello!]\n");
    }

    @Override
    public void doWork(){
        System.out.println("[Sd. " + this.Nume + " does the homework!]\n");
    }

    @Override
    public String toString(){
        return "[Sd. " + this.Nume + " " + this.Prenume + ", " + "Anul de Studiu " + this.An_De_Studiu +
                ", Fac." + this.Acronim_Facultate + ", Varsta " + this.Varsta + " de ani.]\n";
    }

    @Override
    public int compareTo(Human obj){
        return this.getVarsta().compareTo(obj.getVarsta());
    }
}