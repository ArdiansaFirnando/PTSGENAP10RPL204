package com.example.ptsgenap10rpl204;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String nohp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Mahasiswa(String nama, String nim, String nohp, String email) {
        this.nama = nama;
        this.nim = nim;
        this.nohp = nohp;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}