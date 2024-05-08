package com.example.demo.Model;

import java.util.Date;

import jakarta.persistence.*;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;

@Entity(name = "xuly")
public class XuLy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaXL", insertable = false, updatable = false)
	private Integer maXL;

	@Column
	private String hinhthucxl;

	@Column
	private Integer sotien;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayXL")
	private Date ngayXL;

	@Column
	private Integer trangthaixl;
	
	@Transient
    private String trangthai;

	@ManyToOne
	@JoinColumn(name = "MaTV")
	private ThanhVien thanhVien;

	public XuLy() {
	}

	public XuLy(Integer maXL, String hinhThucXL, Integer soTien, Date ngayXL, Integer trangThaiXL,
			ThanhVien thanhVien) {
		this.maXL = maXL;
		this.hinhthucxl = hinhThucXL;
		this.sotien = soTien;
		this.ngayXL = ngayXL;
		this.trangthaixl = trangThaiXL;
		this.thanhVien = thanhVien;
	}

	public XuLy(String hinhThucXL, Integer soTien, Date ngayXL, Integer trangThaiXL,
				ThanhVien thanhVien) {
		this.hinhthucxl = hinhThucXL;
		this.sotien = soTien;
		this.ngayXL = ngayXL;
		this.trangthaixl = trangThaiXL;
		this.thanhVien = thanhVien;
	}

	public Integer getMaXL() {
		return maXL;
	}

	public void setMaXL(Integer maXL) {
		this.maXL = maXL;
	}

	public String getHinhThucXL() {
		return hinhthucxl;
	}

	public void setHinhThucXL(String hinhThucXL) {
		this.hinhthucxl = hinhThucXL;
	}

	public Integer getSoTien() {
		return sotien;
	}

	public void setSoTien(Integer soTien) {
		this.sotien = soTien;
	}

	public Date getNgayXL() {
		return ngayXL;
	}

	public void setNgayXL(Date ngayXL) {
		this.ngayXL = ngayXL;
	}

	public Integer getTrangThaiXL() {
		return trangthaixl;
	}

	public void setTrangThaiXL(Integer trangThaiXL) {
		this.trangthaixl = trangThaiXL;
	}

	public ThanhVien getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}
	public String getTrangthai() {
        if (this.trangthaixl == 0) return "Chưa xử lý";
        else return "Đã xử lý";
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

	@Override
	public String toString() {
		return "XuLyModel [maXL=" + maXL + ", hinhThucXL=" + hinhthucxl + ", soTien=" + sotien + ", ngayXL=" + ngayXL
				+ ", trangThaiXL=" + trangthaixl +  "]";
	}

}
