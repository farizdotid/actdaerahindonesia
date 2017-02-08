package meridianid.farizdotid.actdaerahindonesia.model;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public class Desa {

    String id;
    String id_kecamatan;
    String nama;

    public Desa() {
    }

    public Desa(String id, String id_kecamatan, String nama) {
        this.id = id;
        this.id_kecamatan = id_kecamatan;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_kecamatan() {
        return id_kecamatan;
    }

    public void setId_kecamatan(String id_kecamatan) {
        this.id_kecamatan = id_kecamatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}