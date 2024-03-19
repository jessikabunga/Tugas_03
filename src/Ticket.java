public class Ticket {
    private String[] namaPenumpang;
    private String[] asal;
    private String[] tujuan;

    public Ticket(){
        namaPenumpang = new String[]{};
    }

    public Ticket(String namaKereta, int jumlahTiket) {
        namaPenumpang = new String[]{};
        asal = new String[]{};
        tujuan = new String[]{};

    }
    public void setNamaPenumpang(String[] newPenumpang){
        this.namaPenumpang = newPenumpang;
    }

    public String[] getNamaPenumpang(){
        return this.namaPenumpang;
    }

    public void setAsal(String[] newAsal) {
        this.asal = newAsal;
    }

    public String[] getAsal() {
        return this.asal;
    }

    public void setTujuan(String[] newTujuan) {
        this.tujuan = newTujuan;
    }

    public String[] getTujuan() {
        return this.tujuan;
    }
}