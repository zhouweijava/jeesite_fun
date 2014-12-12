/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.hosp.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.hosp.entity.PatientDetail;
import com.thinkgem.jeesite.modules.hosp.dao.PatientDetailDao;

/**
 * 患者用户信息Service
 * @author boonie
 * @version 2014-12-09
 */
@Component
@Transactional(readOnly = true)
public class PatientDetailService extends BaseService {

	@Autowired
	private PatientDetailDao patientDetailDao;
	
	public PatientDetail get(String id) {
		return patientDetailDao.get(id);
	}
	
	public Page<PatientDetail> find(Page<PatientDetail> page, PatientDetail patientDetail) {
		DetachedCriteria dc = patientDetailDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(patientDetail.getPatient_name())){
			dc.add(Restrictions.like("patient_name", "%"+patientDetail.getPatient_name()+"%"));
		}
		dc.add(Restrictions.eq(PatientDetail.FIELD_DEL_FLAG, PatientDetail.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return patientDetailDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(PatientDetail patientDetail) {
		patientDetailDao.save(patientDetail);
	}
	
	@Transactional(readOnly = false)
	public void delete(String id) {
		patientDetailDao.deleteById(id);
	}
	
}
