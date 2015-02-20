/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.hosp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * 患者用户信息Entity
 * @author boonie
 * @version 2014-12-09
 */
@Entity
@Table(name = "hosp_patientdetail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PatientDetail extends IdEntity<PatientDetail> {
	
	private static final long serialVersionUID = 1L;
	private String patient_name; 	// 名称
	private String symptom;
	private String total_cost;
	private String drugs;
	private String west_medicine;
	private String chinese_medicine;
	private String hospital_day;
	private String admission_day;
	private String closing_date;
	private String is_shebao;
	private String is_shaoer;
	private String is_chengzhen;
	private String is_chengxiang;
	private String personal_pay;
	private String overall_pay;
	private String assist_pay;
	private String blas_pay;
	private String test_pay;
	private String check_pay;
	private String dept;
	private String doctor_name;
	private String sb_waishang;
	private String cx_waishang;
	private String is_gaoe;
	private String remark;

	public PatientDetail() {
		super();
	}

	public PatientDetail(String id){
		this();
		this.id = id;
	}
	@ExcelField(title="姓名", align=2, sort=20)
	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	@ExcelField(title="总费用", align=2, sort=30)
	public String getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}
	@ExcelField(title = "诊断", align = 2, sort=25)
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	@ExcelField(title = "药费合计", align = 2, sort=35)
	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}
	@ExcelField(title = "西药", align = 2, sort=40)
	public String getWest_medicine() {
		return west_medicine;
	}

	public void setWest_medicine(String west_medicine) {
		this.west_medicine = west_medicine;
	}
	@ExcelField(title = "中成药", align = 2, sort=45)
	public String getChinese_medicine() {
		return chinese_medicine;
	}

	public void setChinese_medicine(String chinese_medicine) {
		this.chinese_medicine = chinese_medicine;
	}
	@ExcelField(title = "住院天数", align = 2, sort=50)
	public String getHospital_day() {
		return hospital_day;
	}

	public void setHospital_day(String hospital_day) {
		this.hospital_day = hospital_day;
	}
	@ExcelField(title = "入院日期", align = 2, sort=55)
	public String getAdmission_day() {
		return admission_day;
	}

	public void setAdmission_day(String admission_day) {
		this.admission_day = admission_day;
	}
	@ExcelField(title = "结账日期", align = 2, sort=60)
	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}
	@ExcelField(title = "社保", align = 2, sort=65)
	public String getIs_shebao() {
		return is_shebao;
	}

	public void setIs_shebao(String is_shebao) {
		this.is_shebao = is_shebao;
	}
	@ExcelField(title = "少儿", align = 2, sort=70)
	public String getIs_shaoer() {
		return is_shaoer;
	}

	public void setIs_shaoer(String is_shaoer) {
		this.is_shaoer = is_shaoer;
	}
	@ExcelField(title = "城镇", align = 2, sort=75)
	public String getIs_chengzhen() {
		return is_chengzhen;
	}

	public void setIs_chengzhen(String is_chengzhen) {
		this.is_chengzhen = is_chengzhen;
	}
	@ExcelField(title = "个人支付", align = 2, sort=80)
	public String getPersonal_pay() {
		return personal_pay;
	}

	public void setPersonal_pay(String personal_pay) {
		this.personal_pay = personal_pay;
	}
	@ExcelField(title = "城乡", align = 2, sort=85)
	public String getIs_chengxiang() {
		return is_chengxiang;
	}

	public void setIs_chengxiang(String is_chengxiang) {
		this.is_chengxiang = is_chengxiang;
	}
	@ExcelField(title = "统筹支付", align = 2, sort=90)
	public String getOverall_pay() {
		return overall_pay;
	}

	public void setOverall_pay(String overall_pay) {
		this.overall_pay = overall_pay;
	}
	@ExcelField(title = "辅助检查费合计", align = 2, sort=95)
	public String getAssist_pay() {
		return assist_pay;
	}

	public void setAssist_pay(String assist_pay) {
		this.assist_pay = assist_pay;
	}
	@ExcelField(title = "反射费", align = 2, sort=100)
	public String getBlas_pay() {
		return blas_pay;
	}

	public void setBlas_pay(String blas_pay) {
		this.blas_pay = blas_pay;
	}
	@ExcelField(title = "化验费", align = 2, sort=105)
	public String getTest_pay() {
		return test_pay;
	}

	public void setTest_pay(String test_pay) {
		this.test_pay = test_pay;
	}
	@ExcelField(title = "检查费", align = 2, sort=110)
	public String getCheck_pay() {
		return check_pay;
	}

	public void setCheck_pay(String check_pay) {
		this.check_pay = check_pay;
	}
	@ExcelField(title = "科室", align = 2, sort=115)
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	@ExcelField(title = "医生", align = 2, sort=120)
	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	@ExcelField(title = "社保外伤", align = 2, sort=125)
	public String getSb_waishang() {
		return sb_waishang;
	}

	public void setSb_waishang(String sb_waishang) {
		this.sb_waishang = sb_waishang;
	}
	@ExcelField(title = "城乡外伤", align = 2, sort=130)
	public String getCx_waishang() {
		return cx_waishang;
	}

	public void setCx_waishang(String cx_waishang) {
		this.cx_waishang = cx_waishang;
	}
	@ExcelField(title = "高额", align = 2, sort=135)
	public String getIs_gaoe() {
		return is_gaoe;
	}

	public void setIs_gaoe(String is_gaoe) {
		this.is_gaoe = is_gaoe;
	}
	@ExcelField(title = "备注", align = 2, sort=140)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PatientDetail that = (PatientDetail) o;

		if (admission_day != null ? !admission_day.equals(that.admission_day) : that.admission_day != null)
			return false;
		if (assist_pay != null ? !assist_pay.equals(that.assist_pay) : that.assist_pay != null) return false;
		if (blas_pay != null ? !blas_pay.equals(that.blas_pay) : that.blas_pay != null) return false;
		if (check_pay != null ? !check_pay.equals(that.check_pay) : that.check_pay != null) return false;
		if (chinese_medicine != null ? !chinese_medicine.equals(that.chinese_medicine) : that.chinese_medicine != null)
			return false;
		if (closing_date != null ? !closing_date.equals(that.closing_date) : that.closing_date != null) return false;
		if (cx_waishang != null ? !cx_waishang.equals(that.cx_waishang) : that.cx_waishang != null) return false;
		if (dept != null ? !dept.equals(that.dept) : that.dept != null) return false;
		if (doctor_name != null ? !doctor_name.equals(that.doctor_name) : that.doctor_name != null) return false;
		if (drugs != null ? !drugs.equals(that.drugs) : that.drugs != null) return false;
		if (hospital_day != null ? !hospital_day.equals(that.hospital_day) : that.hospital_day != null) return false;
		if (!id.equals(that.id)) return false;
		if (is_chengxiang != null ? !is_chengxiang.equals(that.is_chengxiang) : that.is_chengxiang != null)
			return false;
		if (is_chengzhen != null ? !is_chengzhen.equals(that.is_chengzhen) : that.is_chengzhen != null) return false;
		if (is_gaoe != null ? !is_gaoe.equals(that.is_gaoe) : that.is_gaoe != null) return false;
		if (is_shaoer != null ? !is_shaoer.equals(that.is_shaoer) : that.is_shaoer != null) return false;
		if (is_shebao != null ? !is_shebao.equals(that.is_shebao) : that.is_shebao != null) return false;
		if (overall_pay != null ? !overall_pay.equals(that.overall_pay) : that.overall_pay != null) return false;
		if (patient_name != null ? !patient_name.equals(that.patient_name) : that.patient_name != null) return false;
		if (personal_pay != null ? !personal_pay.equals(that.personal_pay) : that.personal_pay != null) return false;
		if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
		if (sb_waishang != null ? !sb_waishang.equals(that.sb_waishang) : that.sb_waishang != null) return false;
		if (symptom != null ? !symptom.equals(that.symptom) : that.symptom != null) return false;
		if (test_pay != null ? !test_pay.equals(that.test_pay) : that.test_pay != null) return false;
		if (total_cost != null ? !total_cost.equals(that.total_cost) : that.total_cost != null) return false;
		if (west_medicine != null ? !west_medicine.equals(that.west_medicine) : that.west_medicine != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (patient_name != null ? patient_name.hashCode() : 0);
		result = 31 * result + (symptom != null ? symptom.hashCode() : 0);
		result = 31 * result + (total_cost != null ? total_cost.hashCode() : 0);
		result = 31 * result + (drugs != null ? drugs.hashCode() : 0);
		result = 31 * result + (west_medicine != null ? west_medicine.hashCode() : 0);
		result = 31 * result + (chinese_medicine != null ? chinese_medicine.hashCode() : 0);
		result = 31 * result + (hospital_day != null ? hospital_day.hashCode() : 0);
		result = 31 * result + (admission_day != null ? admission_day.hashCode() : 0);
		result = 31 * result + (closing_date != null ? closing_date.hashCode() : 0);
		result = 31 * result + (is_shebao != null ? is_shebao.hashCode() : 0);
		result = 31 * result + (is_shaoer != null ? is_shaoer.hashCode() : 0);
		result = 31 * result + (is_chengzhen != null ? is_chengzhen.hashCode() : 0);
		result = 31 * result + (is_chengxiang != null ? is_chengxiang.hashCode() : 0);
		result = 31 * result + (personal_pay != null ? personal_pay.hashCode() : 0);
		result = 31 * result + (overall_pay != null ? overall_pay.hashCode() : 0);
		result = 31 * result + (assist_pay != null ? assist_pay.hashCode() : 0);
		result = 31 * result + (blas_pay != null ? blas_pay.hashCode() : 0);
		result = 31 * result + (test_pay != null ? test_pay.hashCode() : 0);
		result = 31 * result + (check_pay != null ? check_pay.hashCode() : 0);
		result = 31 * result + (dept != null ? dept.hashCode() : 0);
		result = 31 * result + (doctor_name != null ? doctor_name.hashCode() : 0);
		result = 31 * result + (sb_waishang != null ? sb_waishang.hashCode() : 0);
		result = 31 * result + (cx_waishang != null ? cx_waishang.hashCode() : 0);
		result = 31 * result + (is_gaoe != null ? is_gaoe.hashCode() : 0);
		result = 31 * result + (remark != null ? remark.hashCode() : 0);
		return result;
	}
}


