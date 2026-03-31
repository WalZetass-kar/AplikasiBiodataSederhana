# 📋 Aplikasi Biodata Sederhana (Java)

Aplikasi Biodata Sederhana adalah aplikasi desktop berbasis **Java** yang digunakan untuk mengelola data biodata pengguna secara terstruktur.
Aplikasi ini menyediakan fitur pengelolaan pengguna, biodata, pendidikan, pengalaman, serta pencatatan histori login.

Project ini dibuat sebagai **media pembelajaran pemrograman Java dan pengelolaan data menggunakan konsep CRUD (Create, Read, Update, Delete)**.

---

# 🖥️ Tampilan Aplikasi

Berikut tampilan utama aplikasi:

![Preview Aplikasi](screenshot.png)

---

# 🚀 Fitur Utama

### 📊 Dashboard

Menampilkan halaman utama aplikasi dan informasi sistem.

### 👤 Manajemen Pengguna

Mengelola data pengguna aplikasi seperti:

* Menambah pengguna
* Mengedit pengguna
* Menghapus pengguna

### 📝 Form Biodata

Digunakan untuk menginput dan mengelola biodata pengguna.

### 🎓 Data Pendidikan

Menyimpan riwayat pendidikan pengguna.

### 💼 Data Pengalaman

Menyimpan pengalaman kerja atau kegiatan pengguna.

### 📜 Histori Login

Mencatat aktivitas login setiap pengguna yang masuk ke dalam sistem.

### 🔑 Ubah Password

Memungkinkan pengguna mengganti password akun mereka.

---

# 🔐 Sistem Login

Aplikasi ini memiliki sistem **autentikasi login**.

Jika login berhasil:

* Menu yang sebelumnya terkunci akan terbuka
* Sistem mencatat **histori login pengguna**
* Pengguna dapat mengakses seluruh fitur aplikasi sesuai hak akses

---

# 📖 Cara Menggunakan Aplikasi

Berikut langkah penggunaan aplikasi setelah dijalankan:

### 1️⃣ Login ke Sistem

Saat aplikasi dibuka, pengguna harus melakukan login terlebih dahulu dengan **username dan password** yang terdaftar.

Jika login berhasil:

* Sistem akan membuka seluruh menu yang sebelumnya terkunci
* Aktivitas login akan dicatat pada menu **Histori Login**

---

### 2️⃣ Mengelola Data Pengguna

Masuk ke menu **Pengguna** untuk:

* Menambahkan akun pengguna baru
* Mengedit data pengguna
* Menghapus pengguna yang tidak diperlukan

---

### 3️⃣ Mengisi Form Biodata

Masuk ke menu **Form Biodata** untuk menginput data biodata seperti:

* Nama
* Alamat
* Tanggal lahir
* Informasi pribadi lainnya

Data yang diinput akan tersimpan di dalam database.

---

### 4️⃣ Mengelola Data Pendidikan

Pada menu **Pendidikan**, pengguna dapat menambahkan riwayat pendidikan seperti:

* Nama sekolah atau universitas
* Tahun masuk
* Tahun lulus
* Jurusan atau program studi

---

### 5️⃣ Mengelola Data Pengalaman

Menu **Pengalaman** digunakan untuk menyimpan informasi pengalaman seperti:

* Pengalaman kerja
* Kegiatan organisasi
* Pengalaman proyek

---

### 6️⃣ Melihat Histori Login

Menu **Histori Login** menampilkan riwayat aktivitas login pengguna, seperti:

* Username
* Waktu login
* Aktivitas sistem

Fitur ini membantu memantau penggunaan aplikasi.

---

### 7️⃣ Mengganti Password

Pengguna dapat mengganti password melalui menu **Ubah Password** untuk meningkatkan keamanan akun.

---

# 🧰 Teknologi yang Digunakan

| Teknologi      | Keterangan                       |
| -------------- | -------------------------------- |
| Java           | Bahasa pemrograman utama         |
| Java Swing     | GUI untuk tampilan aplikasi      |
| MySQL / SQLite | Database penyimpanan data        |
| JDBC           | Koneksi antara Java dan database |

---

# 📂 Struktur Menu Aplikasi

```
Dashboard
│
├── Master
├── Pengguna
├── Form Biodata
├── Pendidikan
├── Pengalaman
├── Histori Login
└── Ubah Password
```

---

# ⚙️ Cara Menjalankan Project

### 1️⃣ Clone repository

```
https://github.com/WalZetass-kar/AplikasiBiodataSederhana.git
```

### 2️⃣ Masuk ke folder project

```
cd AplikasiBiodataSederhana.git
```

### 3️⃣ Buka project menggunakan IDE Java

Contoh IDE:

* NetBeans
* IntelliJ IDEA
* Eclipse

### 4️⃣ Jalankan project

Run file **Main.java** atau file utama aplikasi.

---

# 🎯 Tujuan Pembuatan Project

Project ini dibuat untuk:

* Belajar membuat aplikasi desktop menggunakan **Java**
* Memahami konsep **CRUD**
* Mempelajari **sistem login dan autentikasi**
* Mengelola data menggunakan **database**

---

# 👨‍💻 Developer

**M. Ihwal Maulana**

GitHub:
https://github.com/WalZetass-kar

---

# 📄 Lisensi

Project ini dibuat untuk **tujuan pembelajaran dan pengembangan pribadi**.
