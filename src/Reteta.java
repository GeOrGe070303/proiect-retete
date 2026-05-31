public class Reteta {
    private int poza;
    private String denumire;
    private String ingrediente;
    private String descriere;
    private int timp;
    private String pasi;
    private int potriviri;

    public Reteta(int poza, String denumire, String ingrediente,
                  String descriere, int timp, String pasi, int potriviri) {
        this.poza = poza;
        this.denumire = denumire;
        this.ingrediente = ingrediente;
        this.descriere = descriere;
        this.timp = timp;
        this.pasi = pasi;
        this.potriviri = potriviri;
    }

    public String getDenumire() { return denumire; }
    public String getIngrediente() { return ingrediente; }
    public String getDescriere() { return descriere; }
    public int getTimp() { return timp; }
    public String getPasi() { return pasi; }
    public int getPoza() { return poza; }
    public int getPotriviri() { return potriviri; }
}