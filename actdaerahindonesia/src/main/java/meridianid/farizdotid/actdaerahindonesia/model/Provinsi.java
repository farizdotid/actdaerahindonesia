package meridianid.farizdotid.actdaerahindonesia.model;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public class Provinsi {

    String id;
    String nama;

    public Provinsi() {
    }

    public Provinsi(String id, String nama) {
        this.id = id;
        this.nama = nama;
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
}
