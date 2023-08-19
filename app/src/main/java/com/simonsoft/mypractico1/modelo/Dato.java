package com.simonsoft.mypractico1.modelo;

public class Dato {
private String Esp;
private String Eng;

private int foto;

    public Dato(String esp, String eng, int foto) {
        Esp = esp;
        Eng = eng;
        this.foto = foto;
    }

    public String getEsp() {
        return Esp;
    }

    public void setEsp(String esp) {
        Esp = esp;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
