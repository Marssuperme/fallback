package cn.org.gdicpa.web.pub.fileupload;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.util.Debug;
import cn.org.gdicpa.web.pub.util.MyEncrypt;
import cn.org.gdicpa.web.pub.util.Zip;

/**
 * <p>Title: 处理文件上传(新增和修改替换原有文件)的类</p>
 * <p>Description: 处理文件上传(新增和修改替换原有文件)的类</p>
 * <p>Copyright: Copyright (c) 2006, 2008 MaTech Corporation.All rights reserved. </p>
 * <p>Company: Matech  广州铭太信息科技有限公司</p>
 *
 * 本程序及其相关的所有资源均为铭太科技公司研发中心审计开发组所有，
 * 版本发行及解释权归研发中心，公司网站为：http://www.matech.cn
 *
 * 贡献者团队:
 *     铭太科技 - 研发中心，审计开发组
 *
 * @author void
 * 2008-6-7 
 */
public class MyFileUpload {
	private Connection conn = null;

	private String tempPath = "c:\\temp\\";

	private Map parameters = null;

	private String fileRondomNames = "" ;

	private String fileNames = "" ;
	
	private boolean showProcess = false ;
	
	private  String uploadBeanName = "" ;
	
	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFileRondomNames() {
		return fileRondomNames;
	}

	public void setFileRondomNames(String fileRondomNames) {
		this.fileRondomNames = fileRondomNames;
	}

	public Map getMap() {
		return this.parameters;
	}

	public void setMap(Map map) {
		this.parameters = map;
	}

	//获取的上传请求
	private HttpServletRequest request = null;

	//设置最多只允许在内存中存储的数据,单位:字节
	private int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;

	//设置允许用户上传文件大小,单位:字节,共10M
	private long sizeMax = 1000485760;

	/**
	 * 构造方法
	 * @param request
	 * @throws Exception
	 */
	public MyFileUpload(HttpServletRequest request) throws Exception {
		this.request = request;
	}

	/**
	 * 构造方法,从外部传链接进来
	 * @param request
	 * @param conn
	 * @throws Exception
	 */
	public MyFileUpload(HttpServletRequest request, Connection conn)
			throws Exception {
		this.request = request;
		this.conn = conn;
	}


	
	
	
	/**
	 * 为上传准备临时目录，如果目录不存在，会自己建立
	 * @return
	 */
	public String prepareTempDir() {
		
		String temp = this.tempPath + DELUnid.getNumUnid() + "\\";
		if (!new File(this.tempPath).exists()) {
			new File(this.tempPath).mkdir();
		}
		if (!new File(temp).exists()) {
			new File(temp).mkdir();
		}
		
		return temp;
	}
	

	/**
	 * 上传并保存文件到指定目录
	 *
	 * @param strFileName String 文件名，这个参数如果这是为NULL或者""，
	 *            则会使用上传文件的文件名作为文件名
	 * @param strDir String 目录路径，这个参数设置为NULL，或者""，
	 *            则会无条件在c:\temp\目录下新建一个临时目录（以避免并发冲突）；
	 *
	 * @return String  保存的文件的绝对路径
	 *            保存文件的文件名和路径，可以通过：
	 *            Map parameters=null;
	 *            MyFileUpload myfileUpload =new MyFileUpload(request);
	 *            uploadtemppath=myfileUpload.UploadFile();
	 *            parameters=myfileUpload.getMap();
	 *            filename=(String)parameters.get("filename");
	 *            tempdir=(String)parameters.get("tempdir");
	 *            clientFilePath=(String)parameters.get("clientFilePath");  //客户端上传文件的路径
	 *           来获取，其他表单内的变量也是采用类似方式。
	 */
	public String UploadFile(String strFileName, String strDir) {

		Iterator iterator = getFileItems();
		//检查临时目录是否存在,不存在就创建
		String temp = "";
		if (strDir == null || strDir.equals(""))
			temp = this.tempPath + DELUnid.getNumUnid() + "\\";
		else
			temp = strDir;
		if (!new File(this.tempPath).exists()) {
			new File(this.tempPath).mkdir();
		}
		if (!new File(temp).exists()) {
			new File(temp).mkdir();
		}
		while (iterator.hasNext()) {
			FileItem fileItem = (FileItem) iterator.next();

			//其他不是文件域的所有表单信息,会放到MAP中
			if (!fileItem.isFormField()) {
				//上传的是文件信息

				String name = fileItem.getName();
				if ((name == null) || name.equals("") && fileItem.getSize() == 0) {
					continue;
				}

				parameters.put("clientFilePath", name);
				String mime = fileItem.getContentType();
				try {
					//文件保存处理
					String filename = "";
					if (strFileName == null || strFileName.equals("")) {
						filename = this.getFileName(name); //获取不带路径的文件名
					} else {
						filename = strFileName;
					}

					//先保存到临时目录
					String swapfile = temp + filename;
					fileItem.write(new File(swapfile));

					//把最终的文件名页放到MAP中
					parameters.put("filename", filename);
					parameters.put("mime", mime);
					//只有一个上传文件，所有处理完后直接退出，不用考虑其他事项
					continue;
				} catch (Exception e) {
					Debug.print(Debug.iError, "访问失败", e);
					return "";
				}
			} else {

				try {
					//上传的是普通表单字域，这里只读出不做任何处理
					String fieldName = fileItem.getFieldName();

					String value = fileItem.getString("utf-8");
					parameters.put(fieldName, value);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} //循环

		parameters.put("tempdir", temp);
		return temp;
	}

	/**
	 * 初始化并读取上传信息
	 * @return
	 */
	private Iterator getFileItems() {
		// 定义一个HashMap，存放请求参数
		if (this.parameters == null) {
			parameters = new HashMap();
		}

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		//设置允许用户上传文件大小,单位:字节,10M
		servletFileUpload.setSizeMax(sizeMax);
		servletFileUpload.setHeaderEncoding("UTF-8") ;
		if(this.showProcess) {
			servletFileUpload.setProgressListener(new UploadListener(request.getSession(),uploadBeanName));  
			request.getSession().setAttribute(uploadBeanName,initFileUploadStatusBean(request));   
	//		storeFileUploadStatusBean(request.getSession(),initFileUploadStatusBean(request)); 
		}
		
		// 设置缓冲区大小，这里是4kb
		diskFileItemFactory.setSizeThreshold(sizeThreshold);

		Iterator iterator = null;

		//读取上传信息
		try {
			List fileItems = servletFileUpload.parseRequest(request);
			//处理上传项目
			//依次处理每个上传的文件 
			iterator = fileItems.iterator();
		} catch (Exception e) {
			Debug.print(Debug.iError, "读取上传信息失败", e);
		}

		return iterator;
	}

	/**
	 * 从路径中获取单独文件名
	 * @param filepath
	 * @return
	 */
	public String getFileName(String filepath) {
		String returnstr = filepath;
		int length = filepath.trim().length();

		filepath = filepath.replace('\\', '/');
		if (length > 0) {
			int i = filepath.lastIndexOf("/");
			if (i >= 0) {
				filepath = filepath.substring(i + 1);
				returnstr = filepath;
			}
		}
		return returnstr;
	}


	/**
	 * 上传并保存文件到指定目录
	 *
	 * @param 		isUseDefautName boolean 是否用随机名字替换原来的文件名，
	 *           true为是,
	 * @param strDir String 目录路径，这个参数设置为NULL，或者""，
	 *            则会无条件在c:\temp\目录下新建一个临时目录（以避免并发冲突）；
	 *
	 * @return String  保存的文件的绝对路径
	 *            保存文件的文件名和路径，可以通过：
	 *            Map parameters=null;
	 *            MyFileUpload myfileUpload =new MyFileUpload(request);
	 *            uploadtemppath=myfileUpload.UploadFile();
	 *            parameters=myfileUpload.getMap();
	 *            filename=(String)parameters.get("filename");
	 *            tempdir=(String)parameters.get("tempdir");
	 *            clientFilePath=(String)parameters.get("clientFilePath");  //客户端上传文件的路径
	 *           来获取，其他表单内的变量也是采用类似方式。
	 */
	public String UploadFiles(boolean isUseDefautName, String strDir) {

		Iterator iterator = getFileItems();

		//检查临时目录是否存在,不存在就创建
		String temp = "";
		if (strDir == null || strDir.equals(""))
			temp = this.tempPath + DELUnid.getNumUnid() + "\\";
		else
			temp = strDir;
		if (!new File(this.tempPath).exists()) {
			new File(this.tempPath).mkdir();
		}
		if (!new File(temp).exists()) {
			new File(temp).mkdir();
		}
		int i = 0 ;
		while (iterator.hasNext()) {
			FileItem fileItem = (FileItem) iterator.next();

			//其他不是文件域的所有表单信息,会放到MAP中
			if (!fileItem.isFormField()) {
				//上传的是文件信息

				String name = fileItem.getName();
				if ((name == null) || name.equals("") && fileItem.getSize() == 0) {
					continue;
				}

				parameters.put("clientFilePath", name);
				String mime = fileItem.getContentType();

				fileNames += this.getFileName(name) + "," ;

				try {
					//文件保存处理
					String filename = "";
					if (isUseDefautName) {
						filename = this.getFileName(name); //获取不带路径的文件名
					} else {
						String randomName = DELUnid.getNumUnid()+i;
						filename = randomName;

						fileRondomNames += randomName + "," ;
					}

					//先保存到临时目录
					String swapfile = temp + filename;
					fileItem.write(new File(swapfile));

					//把最终的文件名页放到MAP中
					parameters.put("filename", filename);
					parameters.put("mime", mime);
					i++ ;
					continue;
				} catch (Exception e) {
					Debug.print(Debug.iError, "访问失败", e);
					return "";
				}
			} else {

				try {
					//上传的是普通表单字域，这里只读出不做任何处理
					String fieldName = fileItem.getFieldName();

					String value = fileItem.getString("utf-8");
					parameters.put(fieldName, value);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} //循环

		if(!"".equals(fileNames) && !"".equals(fileRondomNames)) {
			fileNames = fileNames.substring(0,fileNames.length()-1) ;
			fileRondomNames = fileRondomNames.substring(0,fileRondomNames.length()-1) ;
		}

		parameters.put("tempdir", temp);
		return temp;
	}
	
	    /**  
	     * 初始化文件上传状态Bean  
	     * @param request  
	     * @return  
	     */  
	    private FileUploadStatus initFileUploadStatusBean(HttpServletRequest request){   
	        FileUploadStatus fUploadStatus=new FileUploadStatus();   
	        fUploadStatus.setStatus("正在准备处理");   
	        fUploadStatus.setUploadTotalSize(request.getContentLength());   
	        fUploadStatus.setProcessStartTime(System.currentTimeMillis());   
	     //   fUploadStatus.setBaseDir(request.getContextPath()+UPLOAD_DIR);   
	        return fUploadStatus;   
	    }

	

		public void setUploadProcess(boolean showProcess,String uploadBeanName) {
			this.showProcess = showProcess ;
			this.uploadBeanName = uploadBeanName;
		} 
	    
	
		/**
		 * 处理上传采集的数据文件的方法,先上传，再解压；
		 * @return 返回存放文件的目录的字符串表示上传并导入成功，返回空字符串表示失败
		 */
		public String UploadData() throws Exception {

			Iterator iterator = getFileItems();

			//检查临时目录是否存在,不存在就创建
			String temp = prepareTempDir();

			String pwd = "";
			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();

				//忽略其他不是文件域的所有表单信息
				if (!item.isFormField()) {
					//上传的是文件信息
					//String fieldName = item.getFieldName();
					String name = item.getName();
					if ((name == null) || name.equals("") && item.getSize() == 0) {
						continue;
					}

					try {
						//文件保存处理
						String filename = this.getFileName(name).toLowerCase(); //获取不带路径的文件名

						//先保存到临时目录
						String swapfile = temp + filename;
						item.write(new File(swapfile));

						//记录文件名，用于生成客户信息
						parameters.put("filename", filename);

						preHandleUploadData(swapfile,pwd,temp);
						
						//只有一个上传文件，所有处理完后直接退出，不用考虑其他事项
						break;
					} catch (Exception e) {
						Debug.print(Debug.iError, "访问失败", e);
						throw e;
					}
				} else {

					//上传的是普通表单字域，这里只读出不做任何处理
					String fieldName = item.getFieldName();
					String value = item.getString("utf-8"); //转换编码,支持导账时指定客户名称

					parameters.put(fieldName, value);
					if (fieldName != null
							&& fieldName.equalsIgnoreCase("mypassword"))
						pwd = value;
				}

			} //循环

			parameters.put("tempdir", temp);
			return temp;
		}

		/**
		 * 预处理文件；主要是解密、解压；
		 * @param name  文件全路径 
		 * @param pwd   密码
		 * @return
		 * @throws Exception
		 */
		public String preHandleUploadData(String name , String pwd,String temp)
				throws Exception{

			//文件保存处理
			String filename = this.getFileName(name).toLowerCase(); //获取不带路径的文件名

			if (filename.indexOf(".zip") > 0) {
				//是zip文件，就解压
				System.out.println("filename1="+filename);
				//Zip.extZipFileList(swapfile, temp);
				Zip.unZip(name, temp, false);
			}

			if (filename.indexOf(".mt_") > 0) {
				//是mt_文件，先解密再解压
				System.out.println("filename2="+filename);

				//再解压
				try {
					//解密文件
					MyEncrypt my = new MyEncrypt();
					if (pwd == null || pwd.equals(""))
						pwd = "mtsoft";
					my.decryptFile(name, pwd,1024);
					
				} catch (Exception e) {
					Debug.print(Debug.iError, "访问失败", e);
					throw new Exception("密码错误");
				}
				//解压文件
				Zip.unZip(name + ".zip", temp, false);
			}

			if (filename.indexOf(".mtd_") > 0) {

				System.out.println("filename3="+filename);

				//是mt_文件，先解密再解压
				//再解压
				try {
					//解密文件
					MyEncrypt my = new MyEncrypt();
					if (pwd == null || pwd.equals(""))
						pwd = "mtsoft";
					my.decryptFile(name, pwd,16000);
				} catch (Exception e) {
					Debug.print(Debug.iError, "访问失败", e);
					throw new Exception("密码错误");
				}
				//解压文件
				Zip.unZip(name + ".zip", temp, false);
			}


			if (filename.indexOf(".mt3_") > 0) {

				System.out.println("filename4="+filename);

				//是mt_文件，先解密再解压
				//再解压
				try {
					//解密文件
					MyEncrypt my = new MyEncrypt();
					if (pwd == null || pwd.equals(""))
						pwd = "mtsoft";
					my.decryptFile3(name, pwd);
				} catch (Exception e) {
					Debug.print(Debug.iError, "访问失败", e);
					throw new Exception("密码错误");
				}
				//解压文件 
				System.out.println("filename5="+filename);
				//Zip.extZipFileList(swapfile + ".zip", temp);
				Zip.unZip(name + ".zip", temp, false);
				System.out.println("filename6="+filename);
			}
			
			//记录文件名，用于生成客户信息
			return filename;
			
		}
}
