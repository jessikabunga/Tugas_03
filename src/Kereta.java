public class Kereta {

    //Mendeklarasikan variabel
    private String namaKereta; //Menyimpan nama kereta, jika kosong, berarti kereta komuter
    private int jumlahTiket; //Menyimpan jumlah tiket yang tersedia
    private Ticket tiket; //Objek dari kelas 'Ticket' untuk menyimpan data

    //Default constructor untuk kereta komuter
    public Kereta() {
        this.namaKereta = ""; //String kosong agar secara default, objek 'Kereta' tidak memiliki nama
        this.jumlahTiket = 1000; //Menetapkan jumlah tiket secara default untuk kereta komuter
        this.tiket = new Ticket(); //Objek baru untuk kelas 'Ticket' yang berfungsi untuk mengelola informasi tiket
    }

    //Overload constructor
    public Kereta(String nama, int jumlahlTiket) {
        this.namaKereta = nama; //Memberikan nama pada kereta sesuai dengan nilai yang diberikan
        this.jumlahTiket = jumlahTiket; //Menetapkan jumlah tiket sesuai nilai yang diberikan
        this.tiket = new Ticket(nama, jumlahTiket); //Objek baru dari kelas 'Ticket' sesuai dengan overload constructor
    }

    //Method untuk menambahkan tiket dengan nama penumpang ke dalam kereta
    public void tambahTiket(String namaPenumpang) {
        if (this.namaKereta.equals("")) { //Memeriksa apabila nama kereta kosong, maka termasuk kereta komuter
            if (jumlahTiket > 0) { //Memeriksa apakah jumlah tiket masih tersedia

                String[] penumpang = tiket.getNamaPenumpang(); //Mengambil data nama penumpang dari objek tiket
                String[] newPenumpang = new String[penumpang.length + 1]; //Membuat array untuk menambah penumpang baru

                //Menyalin data penumpang lama dalam array penumpang baru
                for (int i = 0; i < penumpang.length; i++) {
                    newPenumpang[i] = penumpang[i];
                }
                //Menambahkan penumpang baru dalam array
                newPenumpang[penumpang.length] = namaPenumpang;

                tiket.setNamaPenumpang(newPenumpang); //Mengatur kembali array penumpang di objek tiket dengan array penumpang baru
                jumlahTiket--; //Mengurangi jumlah tiket apabila terjual
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            System.out.println("==================================================");
        }
    }

    // Overload method
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (!this.namaKereta.equals("")) { //Apabila nama kereta tidak kosong, maka termasuk KAJJ
            if (jumlahTiket > 0) { //Memeriksa jumlah tiket
                String[] penumpang = tiket.getNamaPenumpang(); //Mengambil data nama penumpang dari objek tiket

                String[] newPenumpang = new String[penumpang.length + 1]; //Membuat array baru untuk menambah penumpang baru
                String[] newAsal = new String[penumpang.length + 1]; //Membuat array baru untuk menambah asal baru
                String[] newTujuan = new String[penumpang.length + 1]; //Membuat array baru untuk menambah tujuan baru

                //Menyalin data penumpang lama ke array baru
                for (int i = 0; i < penumpang.length; i++) {
                    newPenumpang[i] = penumpang[i];
                    newAsal[i] = tiket.getAsal()[i];
                    newTujuan[i] = tiket.getTujuan()[i];
                }

                newPenumpang[penumpang.length] = namaPenumpang; //Menambahkan penumpang baru ke array baru
                newAsal[penumpang.length] = asal; //Menambahkan asal baru ke array baru
                newTujuan[penumpang.length] = tujuan; //Menambahkan tujuan baru ke array baru

                //Mengatur kembali array penumpang, asal, dan tujuan di objek tiket dengan array baru
                tiket.setNamaPenumpang(newPenumpang);
                tiket.setAsal(newAsal);
                tiket.setTujuan(newTujuan);
                jumlahTiket--; //Mengurangi jumlah tiket apabila sudah terjual
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiket);
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            System.out.println("==================================================");
        }
    }

    //Method untuk menampilkan daftart penumpang kereta api
    public void tampilkanTiket() {
        System.out.println("==================================================");
        if (this.namaKereta.equals("")) { //Apabila nama kereta kosong, maka termasuk kereta komuter
            System.out.println("Daftar penumpang kereta api komuter: ");
            System.out.println("----------------------------");

        } else {
            System.out.println("Daftar penumpang kereta api " + this.namaKereta);
            System.out.println("----------------------------");
        }

        //Mengambil data penumpang, asal, dan tujuan dari objek tiket
        String[] namaPenumpangArray = tiket.getNamaPenumpang();
        String[] asalArray = tiket.getAsal();
        String[] tujuanArray = tiket.getTujuan();


        if (namaPenumpangArray.length > 0) {
            for (int i = 0; i < namaPenumpangArray.length; i++) { //Mengiterasi setiap nama penumpang
                System.out.println("Nama: " + namaPenumpangArray[i]);

                //Memeriksa apakah array bernilai null, apabila tidak null maka kode dalam 'if' akan dijalankan
                if (asalArray != null && tujuanArray != null) {
                    System.out.println("Asal: " + asalArray[i]);
                    System.out.println("Tujuan: " + tujuanArray[i]);
                    System.out.println("----------------------------");
                }
            }

        } else {
            System.out.println("Tidak ada penumpang");
            }
        }
    }