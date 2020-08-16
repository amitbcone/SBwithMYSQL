package com.amit.sbmysql.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Table(name = "MIGRATE_TEST")
@Getter @Setter @NoArgsConstructor
public class MigrateTest implements Serializable{

	private static final long serialVersionUID = -7840181951492331563L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="NVIC", length = 20) private String nv;
	@Column(name="VEHCAT") private String ve;
	@Column(name="AMPACPT") private String amp;
	@Column(name="AAMACPT") private String aam;
	@Column(name="APIACPT") private String api;
	@Column(name="GIOACPT") private String gio;
	@Column(name="SUNACPT") private String sun;
	@Column(name="SHNACPT") private String shn;
	@Column(name="GIOCIACPT") private String gioc;
	@Column(name="JCIACPT") private String jci;
	@Column(name="BINGLEACPT") private String bin;
	@Column(name="ESSACPT") private String ess;
	@Column(name="V03ACPT") private String v03;
	@Column(name="V05ACPT") private String v05;
	@Column(name="AAMRULE") private String aamr;
	@Column(name="AMPRULE") private String ampr;
	@Column(name="APIRULE") private String apir;
	@Column(name="GIORULE") private String gior;
	@Column(name="SUNRULE") private String sunr;
	@Column(name="SHNRULE") private String shnr;
	@Column(name="ESSRULE") private String essr;
	@Column(name="V03RULE") private String v03r;
	@Column(name="V05RULE") private String v05r;
	@Column(name="JCIRULE") private String jcir;
	@Column(name="GIOCIRULE") private String giocr;
	@Column(name="BINGLERULE") private String binr;
	@Column(name="IMRACPT") private String imr;
	@Column(name="IMRRULE") private String imrr;
	
}
