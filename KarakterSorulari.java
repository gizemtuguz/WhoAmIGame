import java.util.HashMap;
import java.util.Map;

// minik bir database oluşturup sorularla karakterleri eşleştirdiğimiz class
public class KarakterSorulari {
    private Map<String, Map<String, Boolean>> karakterOzellikleri;

    public KarakterSorulari() {
        karakterOzellikleri = new HashMap<>();

        // Karakter özelliklerini tanımla
        // Jason karakterinin özellikleri
        Map<String, Boolean> jasonOzellikleri = new HashMap<>();
        jasonOzellikleri.put("Karakterin başında şapka var mı?", true);
        jasonOzellikleri.put("Karakter mor renkli mi?", true);
        jasonOzellikleri.put("Karakterin burnu var mı?", true);
        jasonOzellikleri.put("Karakter kız mı?", false);
        jasonOzellikleri.put("Karakterin iki gözünden fazlası var mı?", false);

        // Telly karakterinin özellikleri
        Map<String, Boolean> tellyOzellikleri = new HashMap<>();
        tellyOzellikleri.put("Karakterin başında şapka var mı?", false);
        tellyOzellikleri.put("Karakter mor renkli mi?", true);
        tellyOzellikleri.put("Karakterin burnu var mı?", true);
        tellyOzellikleri.put("Karakter kız mı?", true);
        tellyOzellikleri.put("Karakterin iki gözünden fazlası var mı?", false);

        // Opus karakterinin özellikleri
        Map<String, Boolean> opusOzellikleri = new HashMap<>();
        opusOzellikleri.put("Karakterin başında şapka var mı?", true);
        opusOzellikleri.put("Karakter mor renkli mi?", false);
        opusOzellikleri.put("Karakterin burnu var mı?", true);
        opusOzellikleri.put("Karakter kız mı?", false);
        opusOzellikleri.put("Karakterin iki gözünden fazlası var mı?", false);

        // Gina karakterinin özellikleri
        Map<String, Boolean> ginaOzellikleri = new HashMap<>();
        ginaOzellikleri.put("Karakterin başında şapka var mı?", false);
        ginaOzellikleri.put("Karakter mor renkli mi?", false);
        ginaOzellikleri.put("Karakterin burnu var mı?", false);
        ginaOzellikleri.put("Karakter kız mı?", true);
        ginaOzellikleri.put("Karakterin iki gözünden fazlası var mı?", true);

        // Edith karakterinin özellikleri
        Map<String, Boolean> edithOzellikleri = new HashMap<>();
        edithOzellikleri.put("Karakterin başında şapka var mı?", false);
        edithOzellikleri.put("Karakter mor renkli mi?", false);
        edithOzellikleri.put("Karakterin burnu var mı?", true);
        edithOzellikleri.put("Karakter kız mı?", true);
        edithOzellikleri.put("Karakterin iki gözünden fazlası var mı?", true);

        // Umberto karakterinin özellikleri
        Map<String, Boolean> umbertoOzellikleri = new HashMap<>();
        umbertoOzellikleri.put("Karakterin başında şapka var mı?", true);
        umbertoOzellikleri.put("Karakter mor renkli mi?", true);
        umbertoOzellikleri.put("Karakterin burnu var mı?", false);
        umbertoOzellikleri.put("Karakter kız mı?", false);
        umbertoOzellikleri.put("Karakterin iki gözünden fazlası var mı?", true);

        // Celia karakterinin özellikleri
        Map<String, Boolean> celiaOzellikleri = new HashMap<>();
        celiaOzellikleri.put("Karakterin başında şapka var mı?", true);
        celiaOzellikleri.put("Karakter mor renkli mi?", true);
        celiaOzellikleri.put("Karakterin burnu var mı?", true);
        celiaOzellikleri.put("Karakter kız mı?", true);
        celiaOzellikleri.put("Karakterin iki gözünden fazlası var mı?", true);

        //Finnian karakterinin özellikleri
        Map<String, Boolean> finnianOzellikleri = new HashMap<>();
        finnianOzellikleri.put("Karakterin başında şapka var mı?", true);
        finnianOzellikleri.put("Karakter mor renkli mi?", false);
        finnianOzellikleri.put("Karakterin burnu var mı?", false);
        finnianOzellikleri.put("Karakter kız mı?", false);
        finnianOzellikleri.put("Karakterin iki gözünden fazlası var mı?", false);


        karakterOzellikleri.put("Jason", jasonOzellikleri);
        karakterOzellikleri.put("Telly", tellyOzellikleri);
        karakterOzellikleri.put("Opus", opusOzellikleri);
        karakterOzellikleri.put("Umberto", umbertoOzellikleri);
        karakterOzellikleri.put("Gina", ginaOzellikleri);
        karakterOzellikleri.put("Celia", celiaOzellikleri);
        karakterOzellikleri.put("Edith", edithOzellikleri);
        karakterOzellikleri.put("Finnian", finnianOzellikleri);

    }

    public String soruyaCevapVer(String karakterAdi, String soru) {
        Map<String, Boolean> ozellikler = karakterOzellikleri.get(karakterAdi);
        if (ozellikler == null) {
            return "Bilinmeyen karakter";
        }
        switch (soru) {
            case "Karakterin başında şapka var mı?":
                return ozellikler.getOrDefault("Karakterin başında şapka var mı?", false) ? "Evet" : "Hayır";
            case "Karakter mor renkli mi?":
                return ozellikler.getOrDefault("Karakter mor renkli mi?", false) ? "Evet" : "Hayır";
            case "Karakterin burnu var mı?":
                return ozellikler.getOrDefault("Karakterin burnu var mı?", false) ? "Evet" : "Hayır";
            case "Karakter kız mı?":
                return ozellikler.getOrDefault("Karakter kız mı?", false) ? "Evet" : "Hayır";
            case "Karakterin iki gözünden fazlası var mı?":
                return ozellikler.getOrDefault("Karakterin iki gözünden fazlası var mı?", false) ? "Evet" : "Hayır";
            default:
                return "Bilinmeyen soru";
        }
    }
}
