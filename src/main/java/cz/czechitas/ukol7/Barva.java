package cz.czechitas.ukol7;

public enum Barva {
    tyrkysova("Tyrkysová"),
    modra("Modrá"),
    zluta("Žlutá"),
    zelena("Zelená"),
    fialova("Fialová"),
    ruzova("Růžová"),
            ;

    private final String textBarvy;

    Barva(String textBarvy){
        this.textBarvy = textBarvy;
    }
    public String getTextBarvy(){
        return textBarvy;
    }
}
