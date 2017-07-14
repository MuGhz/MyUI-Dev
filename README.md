**Codebase MyUI**
-

Spesifikasi :

- Target SDK : Marshmallow (25)
- Minimum SDK : Ice Cream Sandwich (15)

Terdapat 3 _Activity_ utama yang telah disediakan :

- LoginActivity

    _Logic_ untuk _login_ diimplementasikan di _activity_ ini

- HomeActivity

    _Logic_ untuk halaman utama (Termasuk _behaviour_ dari _Footer Tab_) diimplementasikan di _activity_ ini
    
- DetailActivity

    _Activity_ yang dijalankan ketika _button Academic Tracker_ di tekan

Terdapat 2 _Fragment_ utama yang telah disediakan :

- MainFragment

    _Fragment_ yang dijalankan ketika _tab_ Menu aktif

- JadwalFragment

    _Fragment_ yang dijalankan ketika _tab_ Jadwal Kuliah aktif


Untuk saat ini kalian diminta untuk mengimplementasikan :

- [ ] Silahkan implementasi untuk _tab_ identitas. Untuk format halamant tersebut silahkan gunakan kreasi kalian.
Berikut adalah _field_ yang diharapkan ada pada halaman Identitas :

    - Nama
    - NPM
    - Jurusan
    - Program (S1 Reguler, S1 Paralel, dsb)

- [ ] Silahkan implementasi _redirection tab_ yang sesuai ( Ketika memilih suatu tab apapun, ketika ditekan tombol back maka 
halaman yang dimunculkan adalah halaman _login_, saat ini _logic_ tersebut belum diimplementasikan)

- [ ] Ubah nama "Ilyas" pada halaman utama menjadi username yang dimasukkan ketika login
