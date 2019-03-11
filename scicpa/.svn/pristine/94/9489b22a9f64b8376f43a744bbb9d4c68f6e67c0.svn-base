package cn.org.gdicpa.web.pub.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import java.io.OutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class FileUtil {

	/**
	 * 缺省的文件目录，值为{@value}
	 * @since 1.0
	 */
	public static final String DefaultFileDir ="/root";
	
	/**
	 * 将一个目录下的文件夹压缩。返回byte[]
	 * 
	 * @param directoryPath
	 * @return
	 */
	public int writeZipFileByDirectory(String directoryPath, OutputStream out) {
		File f = null;
		java.io.FileInputStream fis = null;
		try {
			// 获取文件目录的路径
			final String path = UTILPublic.getWarPath() + "/" + directoryPath;
			f = new File(path);
			if (f.isDirectory()) {
				// 获取目录下所有.exe,dll,ini,dat文件名。
				String[] fs = f.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.toLowerCase().indexOf(".exe") >= 0
								|| name.toLowerCase().indexOf(".dll") >= 0
								|| name.toLowerCase().indexOf(".ini") >= 0
								|| name.toLowerCase().indexOf(".dat") >= 0;
					}
				});

				ZipOutputStream zos = new ZipOutputStream(out);
				fis = null;
				// 压缩文件

				int realLength;// 实际的长度
				final int length = 1024;// 每次读取的长度
				byte[] buffer = new byte[length];

				for (int i = 0; i < fs.length; i++) {
					f = new File(path + "/" + fs[i]);
					if (f.exists()) {
						fis = new FileInputStream(f);
						zos.putNextEntry(new ZipEntry(f.getName()));

						// 写数据
						while ((realLength = fis.read(buffer, 0, length)) != -1) {
							zos.write(buffer, 0, realLength);
						}
						zos.closeEntry();
						fis.close();
					}
				}
				zos.close();

			} else {
				throw new Exception("\n:::找不到路径" + path + ":::\n");
			}
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将一个目录下的文件夹压缩。返回byte[]
	 * 
	 * @param directoryPath
	 * @return
	 */
	public byte[] getZipFileByDirectory(String directoryPath) {
		File f = null;
		java.io.FileInputStream fis = null;
		try {
			// 获取文件目录的路径
			final String path = UTILPublic.getWarPath() + "/" + directoryPath;
			f = new File(path);
			if (f.isDirectory()) {
				// 获取目录下所有.exe,dll,ini文件名。
				String[] fs = f.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.toLowerCase().indexOf(".exe") >= 0
								|| name.toLowerCase().indexOf(".dll") >= 0
								|| name.toLowerCase().indexOf(".ini") >= 0;
					}
				});
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ZipOutputStream zos = new ZipOutputStream(baos);
				fis = null;
				// 压缩文件

				int realLength;// 实际的长度
				final int length = 1024;// 每次读取的长度
				byte[] buffer = new byte[length];

				for (int i = 0; i < fs.length; i++) {
					f = new File(path + "/" + fs[i]);
					if (f.exists()) {
						fis = new FileInputStream(f);
						zos.putNextEntry(new ZipEntry(f.getName()));

						// 写数据
						while ((realLength = fis.read(buffer, 0, length)) != -1) {
							zos.write(buffer, 0, realLength);
						}
						zos.closeEntry();
						fis.close();
					}
				}
				zos.close();
				baos.close();
				return baos.toByteArray();

			} else {
				throw new Exception("\n:::找不到路径" + path + ":::\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 得到某个目录下的所有文件对象 可以过滤得到某类特定的带扩展名的或包含某名字的文件
	 */
	public static String[] getFilesAndDir(String path, final String sFilter) {
		if (path == null)
			return null;
		File dir = new File(path);
		String filename;
		String[] children;
		FilenameFilter filter;

		if (sFilter != null) {
			filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return (name.toLowerCase()).indexOf(sFilter.toLowerCase()) != -1;
				}
			}; 
			children = dir.list(filter);
		} else {
			children = dir.list();
		}

		return children;
	}

	public void delFile(File f) {

		try {
			// 获取文件目录的路径
			// final String path=DelPublic.getWarPath()+"/"+directoryPath;

			if (f.isDirectory()) {
				File[] fs = f.listFiles();

				for (int i = 0; i < fs.length; i++) {
					delFile(fs[i]);
				}
				f.delete();
				// new File(f.getAbsolutePath()).delete();

			} else {
				f.delete();
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {

		}
	}

	public void delFileByWebRoot(String directoryPath) {
		final String path = UTILPublic.getWarPath() + "/" + directoryPath;
		delFile(new File(path));

	}

	public void createDirectoryByWebRoot(String directoryPath) {
		final String path = UTILPublic.getWarPath() + "/" + directoryPath;
		try {
			new File(path).mkdir();
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

	}

	
	//检测某路径下所有名字为数字的目录，把这些目录都删除掉，其它的不符合这个规则的不要删除。
	  public static void delDirForNum(final String path) throws Exception{
		  	//如果目录为空，直接返回
		    if (path == null || path.equals(""))
		      return;
		    //创建文件对象
		    File fdir =  new File(path);
		    //得到下面所有的子目录
		    File[] fchildrens = fdir.listFiles();
		    /**
		     * 如果文件存在并且是一个目录，则递归调用本方法
		     * 如果是一文件，直接删除
		     */
		    for (int i = 0; i < fchildrens.length; i++) {
		        if (fchildrens[i].isDirectory()&&isNumeric(fchildrens[i].getName())){ //删除数字目录则
		        	delDir(fchildrens[i].getPath());
		        }
		      }
	}

	  //判断某字符串是否全为数字
	  public static boolean isNumeric(String strName){
		  boolean flag = false;
		  Pattern pattern = Pattern.compile("[0-9]*");
		  Matcher isNum = pattern.matcher(strName);
		  if(isNum.matches()){
			  flag = true;
		  }

		  return flag;
	  }
	  
	  /**
		 * 清除整个目录及其子目录下的所有文件
		 * <p>
		 *   调用举例:
		 *   <pre>
		 *	   <code>UTILFile file = new UTILFile();</code>
		 *	   <code>file.delDir("d:\\_temp");</code>
		 *   </pre>
		 * </p>
		 *
		 * @param path 要清除的文件目录
		 * @throws Exception 如果目录不存在或删除出错，将抛出此异常.
		 * @see DelPublic#delete(String)
		 * @since 1.0
		 */
	  public static void delDir(final String path) throws Exception{
	  	//如果目录为空，直接返回
	    if (path == null || path.equals(""))
	      return;
	    //创建文件对象
	    File fdir = new File(path);
	    //得到下面所有的子目录
	    File[] fchildrens = fdir.listFiles();
	    /**
	     * 如果文件存在并且是一个目录，则递归调用本方法
	     * 如果是一文件，直接删除
	     */
	    for (int i = 0; i < fchildrens.length; i++) {
	      if (fchildrens[i].isDirectory())
	        delDir(fchildrens[i].getPath());
	      fchildrens[i].delete();
	    }
	    fdir.delete();
	  }

	  
	public static void main(String[] args) {
		new FileUtil().delFile(new File("C://aaa"));

	}
}
