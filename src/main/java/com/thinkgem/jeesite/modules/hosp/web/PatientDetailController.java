/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.hosp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.hosp.entity.PatientDetail;
import com.thinkgem.jeesite.modules.hosp.service.PatientDetailService;

/**
 * 患者用户信息Controller
 * @author boonie
 * @version 2014-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/hosp/patientDetail")
public class PatientDetailController extends BaseController {

	@Autowired
	private PatientDetailService patientDetailService;
	
	@ModelAttribute
	public PatientDetail get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return patientDetailService.get(id);
		}else{
			return new PatientDetail();
		}
	}
	
	@RequiresPermissions("hosp:patientDetail:view")
	@RequestMapping(value = {"list", ""})
	public String list(PatientDetail patientDetail, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			patientDetail.setCreateBy(user);
		}
        Page<PatientDetail> page = patientDetailService.find(new Page<PatientDetail>(request, response), patientDetail); 
        model.addAttribute("page", page);
		return "modules/" + "hosp/patientDetailList";
	}

	@RequiresPermissions("hosp:patientDetail:view")
	@RequestMapping(value = "form")
	public String form(PatientDetail patientDetail, Model model) {
		model.addAttribute("patientDetail", patientDetail);
		return "modules/" + "hosp/patientDetailForm";
	}

	@RequiresPermissions("hosp:patientDetail:edit")
	@RequestMapping(value = "save")
	public String save(PatientDetail patientDetail, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, patientDetail)){
			return form(patientDetail, model);
		}
		patientDetailService.save(patientDetail);
		addMessage(redirectAttributes, "保存患者用户信息'" + patientDetail.getPatient_name() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/hosp/patientDetail/?repage";
	}
	
	@RequiresPermissions("hosp:patientDetail:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		patientDetailService.delete(id);
		addMessage(redirectAttributes, "删除患者用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/hosp/patientDetail/?repage";
	}

}
