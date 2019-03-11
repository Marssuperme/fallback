package cn.org.gdicpa.web.action.uploadProcess;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.fileupload.FileUploadStatus;
import cn.org.gdicpa.web.pub.fileupload.MyFileUpload;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.attachFileUploadService.AttachFileUploadService;
import cn.org.gdicpa.web.service.attachFileUploadService.model.AttachFile;


public class UploadProcessAction extends MultiActionController {
	
	
	  public ModelAndView attachFileUpload(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
			Connection conn = null;
			try {
				conn = new DBConnect().getConnect();
				String beanName = StringUtil.showNull(request.getParameter("beanName"));
				MyFileUpload myfileUpload = new MyFileUpload(request);
				myfileUpload.setUploadProcess(true,beanName) ;
				
				response.setContentType("text/html;charset=UTF-8") ;
				
				//文件上传路径
				String path = request.getSession().getServletContext().getRealPath("/") +"common/attachFile/";
				File file = new File(path);
				if(!file.exists()) {
					file.mkdirs() ;
				}
				//文件上传的临时路径 
				String tempPath = path + "temp/"  ;
				File tempFilePath = new File(tempPath) ; 
				if(!tempFilePath.exists()) {
					tempFilePath.mkdir() ;
				}
				
				String uploadTempPath = myfileUpload.UploadFile(null, tempPath);
				Map parameters = myfileUpload.getMap();
				
				String fileTempName = DELUnid.getNumUnid() ; //生成一个随机文件名
				String fileName = (String)parameters.get("filename") ;  
				String indexTable = (String)parameters.get("indexTable") ; //文件所属模块索引
				String indexMetaData = (String)parameters.get("indexMetaData") ; //文件所属模块的记录数据库对应的列名
				String indexId = (String)parameters.get("indexId") ; //文件所属模块的记录的索引
				String mark = (String)parameters.get("mark") ;
				String tid = (String)parameters.get("mainId") ;
				
				path += indexTable + "/" ;
				File file2 = new File(path);
				if(!file2.exists()) {
					file2.mkdir() ;
				}
			
				//看这个临时文件名有没有被使用了，有就重新生成
				File newFile = new File(path+fileTempName) ;
				while(newFile.exists()) {
					fileTempName = DELUnid.getNumUnid() ; //重新生成文件名
					newFile = new File(path+fileTempName) ;
				}
				
				//把文件从临时文件夹中拷走
				File tempFile = new File(uploadTempPath+fileName) ;
				FileInputStream input = new FileInputStream(tempFile);
				FileOutputStream output = new FileOutputStream(newFile);
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
				//拷	贝后删除临时文件夹里的文件 
				tempFile.delete() ;
				
				response.getWriter().println("<script>window.parent.$.updateAttr('"+fileTempName+"','"+mark+"','"+indexTable+"','"+indexId+"');</script>");
				
				//下面开始插入数据库记录
				AttachFile attachFile = new AttachFile() ;
				AttachFileUploadService afs = new AttachFileUploadService(conn) ;
				attachFile.setIndexTable(indexTable);
				attachFile.setIndexMetaData(indexMetaData);
				attachFile.setIndexId(indexId);
				attachFile.setFileName(fileName);
				attachFile.setFileTempName(fileTempName);
				attachFile.setTimeFlag(tid);
				
				afs.save(attachFile) ;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(conn);
			}
			return null;
		  
	    }
	  
	  public void uploadProcess(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		  	
		   	ASFuntion asf = new ASFuntion() ;
		   	String uploadBeanName = asf.showNull(request.getParameter("beanName")) ;
	        FileUploadStatus fUploadStatus=(FileUploadStatus)request.getSession().getAttribute(uploadBeanName);   
	      
	        if(fUploadStatus == null) {
	        	response.getWriter().write( "上传总进度:0%，已上传:0K &nbsp;&nbsp;<div id=\"progressBar\" class=\"coolDiv\" oncontextmenu=\"return false;\">"  
	        			+"<div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: 0%;\"></div></div>") ;
	        	return ;
	        }
	        
	        long percentComplete = (long)Math.floor(((double) fUploadStatus.getReadTotalSize()/(double) fUploadStatus.getUploadTotalSize())*100.0);   
	        response.setContentType("text/xml");   
	        response.setCharacterEncoding("UTF-8");   
	        response.setHeader("Cache-Control", "no-cache");  
	        
	        if ( ((long)fUploadStatus.getReadTotalSize() == (long)fUploadStatus.getUploadTotalSize()) || (fUploadStatus.getCancel() == true)){   
	        	response.getWriter().write("上传成功..."+ percentComplete + "% &nbsp;&nbsp;<div id=\"progressBar\" class=\"coolDiv\" oncontextmenu=\"return false;\">"  
                    + "<div class=\"prog-border\"><div class=\"prog-bar\" style=\"width:" + percentComplete + "%;\"></div></div></div>");   
	        }else{
	        	
	        	//将Bytes单位化成K
	        	long kTotalSize = (long)Math.floor(((double) fUploadStatus.getReadTotalSize()/1024.0));
	            response.getWriter().write( "上传总进度:"+ percentComplete + "%，已上传:"+kTotalSize+"K &nbsp;&nbsp;<div id=\"progressBar\" class=\"coolDiv\" oncontextmenu=\"return false;\">"  
	        			+"<div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: "+ percentComplete + "%;\"></div></div></div>") ;
	        }   
	    }
	
	
	  public void fileUploadProcess(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		   	ASFuntion asf = new ASFuntion() ;
		   	String uploadBeanName = asf.showNull(request.getParameter("beanName")) ;
	        FileUploadStatus fUploadStatus=(FileUploadStatus)request.getSession().getAttribute(uploadBeanName);   
	        if(fUploadStatus == null) {
	        	response.getWriter().write("&nbsp;&nbsp;&nbsp;正在上传...0% <div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: " 
	        			+"0%;\"></div></div>&nbsp;&nbsp;&nbsp;") ;
	        	return ;
	        }
	        
	        long percentComplete = (long)Math.floor(((double) fUploadStatus.getReadTotalSize()/(double) fUploadStatus.getUploadTotalSize())*100.0);   
	        System.out.println("com:"+percentComplete);   
	        response.setContentType("text/xml");   
	        response.setCharacterEncoding("UTF-8");   
	        response.setHeader("Cache-Control", "no-cache");   
	        if (((long)fUploadStatus.getReadTotalSize() == (long)fUploadStatus.getUploadTotalSize()) || (fUploadStatus.getCancel() == true)){
	        	response.getWriter().write("&nbsp;&nbsp;&nbsp;上传成功..."+ percentComplete + "% <div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: "  
                        + percentComplete + "%;\"></div></div>&nbsp;&nbsp;&nbsp;"+fUploadStatus.getStatus().toString()+"&nbsp;&nbsp;&nbsp;正在处理文件,请稍候...");    
	        }else{   
	            response.getWriter().write("&nbsp;&nbsp;&nbsp;正在上传..."+ percentComplete + "% <div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: "  
	                                + percentComplete + "%;\"></div></div>&nbsp;&nbsp;&nbsp;"+fUploadStatus.getStatus().toString());   
	        }   
	    }
	  
	  
	  public void deteleFile(HttpServletRequest request,
				HttpServletResponse response) {
			
			PrintWriter out = null ;
			Connection conn = null;
			try {
				conn = new DBConnect().getConnect();
				out = response.getWriter() ;

				ASFuntion asf = new ASFuntion() ;
			
				String fileName = asf.showNull(request.getParameter("fileTempName")) ;
				String indexTable = asf.showNull(request.getParameter("indexTable")) ;
				String indexId = asf.showNull(request.getParameter("indexId")) ;
				
				if (fileName != null && !"".equals(fileName)) {

					String path = request.getSession().getServletContext().getRealPath("/")+"common/attachFile/"+indexTable+"/";
					String newfile = path + fileName;
					
					File file = new File(newfile);
					
					if(file.exists()) {
						if(file.delete()) {
							out.write("suc") ;
						}else {
							out.write("fail") ;
						}
					} else {
						 out.write("notExist") ;
					}
					
				}
				
				//删除数据库记录 
				AttachFileUploadService afs = new AttachFileUploadService(conn) ;
				afs.delete(indexTable, indexId, fileName) ;
			
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(conn);
				out.close() ;
			}
		}
	  
	  
	  public void getFiles(HttpServletRequest request,
				HttpServletResponse response) {
			PrintWriter out = null ;
			Connection conn = null;
			try {
				conn = new DBConnect().getConnect();
				response.setCharacterEncoding("UTF-8") ;
				out = response.getWriter() ;

				ASFuntion asf = new ASFuntion() ;
			
				String indexTable = asf.showNull(request.getParameter("indexTable")) ;
				String indexId = asf.showNull(request.getParameter("indexId")) ;
				
				//列出本模块的所有附件
		    	AttachFileUploadService attachFileService = new AttachFileUploadService(conn) ;
		    	List attachFileList = attachFileService.getAttachFile(indexTable,indexId) ;
		    	String jsonStr = JSONArray.fromObject(attachFileList).toString() ;
		    	out.write(jsonStr) ;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(conn);
				out.close() ;
			}
		}
	  
	  
	  /**
		 * 下载附件
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ModelAndView download(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			Connection conn = null;
			try {
				
				response.setContentType("text/html;charset=utf-8");
				conn = new DBConnect().getConnect();
				ASFuntion CHF = new ASFuntion();
				
				String fileTempName = CHF.showNull(request.getParameter("fileTempName")) ;
				String indexTable = CHF.showNull(request.getParameter("indexTable")) ;
				String indexId = CHF.showNull(request.getParameter("indexId")) ;
				String downloadCallback = CHF.showNull(request.getParameter("downloadCallback")) ;
				
				String path = request.getSession().getServletContext().getRealPath("/")+"common/attachFile/"+indexTable + "/";
				fileTempName = URLEncoder.encode(fileTempName, "UTF-8");

				if (!new File(path+fileTempName).exists()) {
					PrintWriter out = response.getWriter();
					out.println("<script language=javascript>");
					out.println("	window.parent.alert(\"下载文件失败，找不到对应文件，请联系管理员！\");");
					out.println("</script>");
					out.close();
					System.out.println("error:下载文件出错了,找不到对应的文件!");
					return null;
				} else {
					String fileName =new AttachFileUploadService(conn).getAttachFile(indexTable,indexId,fileTempName).getFileName();
					fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
					response.setContentType("application/x-msdownload");
					response.setHeader("Content-disposition",
							"attachment; filename=" + fileName);
					
					//开始下载
					OutputStream os = response.getOutputStream();
					BufferedInputStream bis = new BufferedInputStream(
							new FileInputStream(new File(path+fileTempName)));

					byte b[] = new byte[512];
					int len;

					while((len = bis.read(b)) != -1){
						os.write(b, 0, len);
					}
					
					os.flush();
					bis.close();
					os.close();
					
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				DbUtil.close(conn);
			}

			return null;
		}
	
		/**
		 * 
		 * 文件下载
		 * 
		 * */
		public ModelAndView downloadFile(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			Connection conn = null;
			ASFuntion CHF = new ASFuntion();
			try {
				response.setContentType("text/html;charset=utf-8");
				String attachmentId = CHF.showNull(request.getParameter("attachmentId"));  
				String filename = "";
				
				String[] attachmentIds = {"micfoNo_glff","micfoNo_djb","zckjs_sqzczl","zckjs_zssqb","zckjs_zsgrjlb",
											"zckjs_plzsb","fzyhy_djb","fzyhy_zhsqb","kjsws_bgsxb","kjsws_fsbgsxb",
											"blcs_sjywzmzl"};
				
				String[] attachmentNames = {"广东省注册会计师协会非执业会员管理办法.doc","非执业会员登记表.xls","注册会计师申请注册材料.doc","注册会计师转所申请表.doc","注册会计师转所个人简历表.doc",
											"注册会计师批量转所表.doc","中国注册会计师协会非执业会员登记表.xls","中国注册会计师协会非执业会员转会申请表.xls","会计师事务所变更事项情况表.doc","会计师事务所分所变更事项情况表.doc",
											"办理从事审计业务证明资料.doc"};
				
				for (int i = 0; i < attachmentNames.length; i++) {
					if(attachmentIds[i].equals(attachmentId)){
						filename = attachmentNames[i];
						break;
					}
				}
				
				String path = UploadProcessAction.class.getClassLoader().getResource("").getPath();
				path = path.substring(0, (path.indexOf("-") - 3))+ "common/member/attachFiles/"+filename;
				System.out.println("path="+path);
				if (!new File(path).exists()) {
					PrintWriter out = response.getWriter();
					out.println("<script language=javascript>");
					out.println("	window.parent.alert(\"下载文件失败，找不到对应文件，请联系管理员！\");");
					out.println("</script>");
					out.close();
					System.out.println("error:下载文件出错了,找不到对应的文件!");
					return null;
				} else {
					filename = URLEncoder.encode(filename, "UTF-8");
					response.setContentType("application/x-msdownload");
					response.setHeader("Content-disposition",
							"attachment;filename=" + filename);
					OutputStream os = response.getOutputStream();
					BufferedInputStream bis = new BufferedInputStream(
							new FileInputStream(new File(path)));

					byte b[] = new byte[512];
					int len;

					while ((len = bis.read(b)) != -1) {
						os.write(b, 0, len);
					}

					os.flush();
					bis.close();
					os.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				DbUtil.close(conn);
			}

			return null;
		}
		
		
}
