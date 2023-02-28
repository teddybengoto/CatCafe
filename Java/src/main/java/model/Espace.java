package model;

public enum Espace {
    

    Jeu(10), Coworking(10), Chill(10), SalonDeThe(10);

    private int capacite ;

    private Espace(int capacite) {
        this.capacite=capacite;
        
    }

    public int getCapacite() {
        return capacite;
        
    }

    public void setCapacite( int capacite) {
        this.capacite=capacite;
        
    }

}
