# Janji
Saya Nezhad Ahmad Maliki dengan NIM 2503880 mengerjakan Tugas Praktikum 5 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

# Struktur File

```
C:.
├───.idea
│       .gitignore
│       misc.xml
│       modules.xml
│       tepe4.iml
│       uiDesigner.xml
│       workspace.xml
│
├───Dokumentasi
│       disclaimer klo mau apus data.png
│       isi .form.png
│       komentar abis input.png
│       tampilan edit data.png
│       tampilan input.png
│
├───lib
│       mysql-connector-j-26.7.0.jar
│
├───out
│   └───production
│       └───Persons
│           │   Database.class
│           │   Person.class
│           │   PersonMenu$1.class
│           │   PersonMenu$2.class
│           │   PersonMenu$3.class
│           │   PersonMenu$4.class
│           │   PersonMenu$5.class
│           │   PersonMenu.class
│           │
│           └───com
│               └───intellij
│                   └───uiDesigner
│                       └───core
│                               AbstractLayout.class
│                               DimensionInfo.class
│                               GridConstraints.class
│                               GridLayoutManager.class
│                               HorizontalInfo.class
│                               LayoutState.class
│                               Spacer.class
│                               SupportCode$TextWithMnemonic.class
│                               SupportCode.class
│                               Util.class
│                               VerticalInfo.class
│
└───Persons
    │   Persons.iml
    │
    └───src
            Database.java
            Person.java
            PersonMenu.form
            PersonMenu.java
```

# Fungsi program & Alur Program

## Tujuan dibuatnya program ini ialah untuk mengolah data dari penduduk tau warga yang ada dengan ruang lingkup yaitu kampus JokoWowo.
### 1. Desain Class `Person`
Semua atribut yang ada di class dibikin private. Jadi kalau mau ngambil atau ngubah nilainya, harus lewat method getter dan setter:
- `id` (string): 
- `nama` (string): 
- `lahir` (int):
- `kategori` (string):
- `gmail` (string):

### 4. Alur Program (Flow Kode), Alur Design

jadi alur pada program ini cukup sederhana yaitu user diberikan sebuah tampilan yang berisi opsi untuk menambahkan data dan cancel. User dapat mengisi sendiri data yang terdiri dari id, nama, tahun lahir, dan gmail. untuk kategori, user dapat memilih opsi yang terdiri dari mahasiswa, dosen, dan staff. user juga dapat melihat daftar dari semua data yang ada pada table bagian bawah yang dapat discroll.

user juga dapat mengupdate dan mendelete data dengan cara mengklik terlebih dahulu data yang akan diupdate atau di delete yang ada pada table. kemudian, tampilan yang awalnya pada sebelah kanan itu hanya add dan cancel akan berubah menjadi update cancel dan delete. ketika user ingin mendelete suatu data, maka user akan diberikan "disclaimer" terlebih dahulu untuk memastikan kalau user yakin atau tidak untuk menghapus data tersebut.

untuk penjelasan dari design .form, pada bagian id, nama, tahun lahir, dan gmail itu menggunakan Jtextfield, kemudian untuk tombol add, update, cancel, dan delete menggunakan Jbutton. untuk bagian teks di sebelah kiri dan header menggunakan Jlabel. kemudian untuk bagian tabel menggunakan Jscrollpanel yang kemudian dimasukkan Jtable didalamnya.

Program ini menggunakan database mysql yang digunakan untuk mengimpan semua data yang ada.

# Dokumentasi

## Input
<img src="Dokumentasi/add.gif" width="100%">
