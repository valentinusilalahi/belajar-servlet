package com.silalahi.valentinus.belajar.aplikasi.javaweb;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormMahasiswaServlet extends HttpServlet {

    private MahasiswaDao mahasiswaDao = new MahasiswaDao();

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        //membuat objek mahasiswa
        try {

            Mahasiswa m = new Mahasiswa();
            m.setNim(req.getParameter("nim"));
            m.setNama(req.getParameter("nama"));
            m.setTempatLahir(req.getParameter("tempat_lahir"));

            String strTanggalLahir = req.getParameter("tanggal_lahir");
            SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");
            m.setTanggalLahir(formatterTanggal.parse(strTanggalLahir));

            m.setJenisKelamin(JenisKelamin.valueOf(req.getParameter("jenis_kelamin").toUpperCase()));
            m.setAlamat(req.getParameter("alamat"));

            mahasiswaDao.simpan(m);

            res.sendRedirect("form.html");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
