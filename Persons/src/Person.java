public class Person {
    private String id;
    private String nama;
    private int lahir;
    private String kategori;
    private String gmail;

    public Person(String id, String nama, int lahir, String kategori, String gmail) {
        this.id = id;
        this.nama = nama;
        this.lahir = lahir;
        this.kategori = kategori;
        this.gmail = gmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLahir() {
        return lahir;
    }

    public void setLahir(int lahir) {
        this.lahir = lahir;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}