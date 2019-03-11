package cn.org.gdicpa.web.service.education;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.util.StringUtil;

public class InAndExpToolAction  extends MultiActionController{
	private static String TOOL_HTML = "/common/dataGather/yjDataHandle.jsp";
	public ModelAndView inport(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(TOOL_HTML);
		try {
			String date = StringUtil.showNull(request.getParameter("date"));
			if("".equals(date)){
				throw new RuntimeException("请选择日期！");
			}
			date = date.replaceAll("-", "");
			InportZIP inport = new InportZIP();
			inport.execute(date);
			model.addObject("msg", "导入成功。");
		} catch (Exception e) {
			//e.printStackTrace();
			model.addObject("err_msg", "导入失败，错吴信息: "+e.getMessage());
		}
		return model;
	}
	public ModelAndView export(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(TOOL_HTML);
		try {
			String date = StringUtil.showNull(request.getParameter("date"));
			if("".equals(date)){
				throw new RuntimeException("请选择日期！");
			}
			date = date.replaceAll("-", "");
			ExportZIP export = new ExportZIP();
			export.execute(date);
			model.addObject("msg", "导出成功。");
		} catch (Exception e) {
			//e.printStackTrace();
			model.addObject("err_msg", "导出失败，错吴信息: "+e.getMessage());
		}
		return model;
	}
}
