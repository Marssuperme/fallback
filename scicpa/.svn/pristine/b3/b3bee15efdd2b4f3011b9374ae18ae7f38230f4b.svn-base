package cn.org.gdicpa.web.pub.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Jerry and cooler
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Zip {

	public void zip(InputStream in, OutputStream out) throws IOException {
		GZIPOutputStream zip = new GZIPOutputStream(out);
		try {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				zip.write(buffer, 0, bytesRead);
			}
			zip.finish();
		} finally {
			if (zip != null) {
				try {
					zip.close();
				} catch (Throwable e) {
				}
			}
		}
	}

	public void zip(File f, File fout) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(f);
			out = new FileOutputStream(fout);
			zip(in, out);
			in.close();
			in = null;
			boolean deleted;
			try {
				deleted = f.delete();
			} catch (Throwable e) {
				deleted = false;
			}
			if (!deleted)
				f.deleteOnExit();
		} catch (IOException e) {
			if (out != null)
				try {
					out.close();
					out = null;
				} catch (Throwable ex) {
				}
			if (fout != null) {
				boolean deleted;
				try {
					deleted = fout.delete();
				} catch (Throwable ex) {
					deleted = false;
				}
				if (!deleted)
					fout.deleteOnExit();
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Throwable e) {
				}
			if (out != null)
				try {
					out.close();
				} catch (Throwable e) {
				}
		}
	}

	public void zip(File fin, String filename) throws IOException {
		zip(fin, new File(filename));
	}

	public void zip(String fin, String fout) throws IOException {
		zip(new File(fin), new File(fout));
	}

	public void zip(String fin, File fout) throws IOException {
		zip(new File(fin), fout);
	}

	public void zip(File f) throws IOException {
		String path = getDirname(f.getPath());
		String name = getBasename(f.getName());
		File dir = new File(path);
		File fout = new File(dir, name + ".zip");
		zip(f, fout);
	}

	public String getDirname(String path) {
		char sep = File.separatorChar;
		int pos1 = path.lastIndexOf(sep);
		int pos2 = path.lastIndexOf('/');
		int pos = pos1;
		if (pos1 < pos2)
			pos = pos2;
		if (pos > 0)
			return path.substring(0, pos);
		return ".";
	}

	public String getBasename(String path) {
		char sep = File.separatorChar;
		int pos1 = path.lastIndexOf(sep);
		int pos2 = path.lastIndexOf('/');
		int pos = pos1;
		if (pos1 < pos2)
			pos = pos2;
		if (pos > 0)
			return path.substring(pos + 1);
		return path;
	}

	public void zip(String fname) throws IOException {
		zip(new File(fname));
	}

	public void unzip(InputStream in, OutputStream out) throws IOException {
		GZIPInputStream unzip = new GZIPInputStream(in);
		try {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = unzip.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		} finally {
			if (unzip != null) {
				try {
					unzip.close();
				} catch (Throwable e) {
				}
			}
		}
	}

	public void unzip(File fin, File fout) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fin);
			out = new FileOutputStream(fout);
			unzip(in, out);
			in.close();
			in = null;
			boolean deleted;
			try {
				deleted = fin.delete();
			} catch (Throwable e) {
				deleted = false;
			}
			if (!deleted)
				fin.deleteOnExit();
		} catch (IOException e) {
			if (out != null)
				try {
					out.close();
					out = null;
				} catch (Throwable ex) {
				}
			if (fout != null) {
				boolean deleted;
				try {
					deleted = fout.delete();
				} catch (Throwable ex) {
					deleted = false;
				}
				if (!deleted)
					fout.deleteOnExit();
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Throwable e) {
				}
			if (out != null)
				try {
					out.close();
				} catch (Throwable e) {
				}
		}
	}

	public void unzip(File fin, String filename) throws IOException {
		unzip(fin, new File(filename));
	}

	public void unzip(String fin, String fout) throws IOException {
		unzip(new File(fin), new File(fout));
	}

	public void unzip(String fin, File fout) throws IOException {
		unzip(new File(fin), fout);
	}

	/**
	 * 解压单个文件的压缩包，请注意如果压缩包有多个文件，不会成功也不会报错
	 *
	 * @param f
	 * @throws IOException
	 */
	public void unzip(File f) throws IOException {
		String path = getDirname(f.getPath());
		String name = getBasename(f.getName());
		int len = name.length();
		File dir = new File(path);
		File fout = new File(dir, name.substring(0, len - 4));
		unzip(f, fout);
	}

	/**
	 * 解压单个文件的压缩包，请注意如果压缩包有多个文件，不会成功也不会报错
	 *
	 * @param fname
	 * @throws IOException
	 */
	public void unzip(String fname) throws IOException {
		unzip(new File(fname));
	}

	/**
	 * 解压含有多个文件的ZIP包
	 *
	 * @param zipFileName
	 * @param extPlace
	 */
	public static void extZipFileList(String zipFileName, String extPlace)
			throws Exception {

		boolean bHandled = false;
		try {

			ZipInputStream in = new ZipInputStream(new FileInputStream(
					zipFileName));

			ZipEntry entry = null;

			while ((entry = in.getNextEntry()) != null) {

				bHandled = true;
				String entryName = entry.getName();

				if (entry.isDirectory()) {
					File file = new File(extPlace + File.separator + entryName);
					file.mkdirs();
					System.out.println("创建文件夹:" + entryName);
				} else {

					FileOutputStream os = new FileOutputStream(extPlace + File.separator + entryName);

					// Transfer bytes from the ZIP file to the output file
					byte[] buf = new byte[4096];

					int len = 0;
					while ((len = in.read(buf)) > 0) {
						os.write(buf, 0, len);
					}
					os.close();
					in.closeEntry();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("文件解压失败:" + e.getMessage(), e);
		}

		if (bHandled)
			System.out.println("解压文件成功");
		else
			throw new Exception("文件解压失败:无法识别文件格式");
	}

	/**
	 * 解压文件
	 *
	 * @param filePath
	 *            待解压的文件,要绝对路径,例如"c:\\zz.zip"
	 * @param outputPath
	 *            存放解压出来文件的目录,例如"c:\\temp"
	 * @param deleteFile
	 *            是否删除原文件
	 * @throws Exception
	 */
	public static void unZip(String filePath, String outputPath, boolean deleteFile)
			throws Exception {

		final int BUFFER = 1024;

		try {
			File file = new File(filePath);

			if (!file.exists()) {
				throw new Exception("文件不存在,请重新选择");
			}

			File outputFile = new File(outputPath);
			if (!outputFile.exists()) {
				outputFile.mkdirs();
			}
			long startTime = System.currentTimeMillis(); // 开始解压时间

			System.out.print("开始解压:" + filePath);

			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(file);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));

			java.util.zip.ZipEntry entry;

			while ((entry = zis.getNextEntry()) != null) {

				if (entry.isDirectory()) {
					File f = new File(outputPath + File.separator
							+ entry.getName());
					f.mkdirs();
					continue;
				} else {
					File f = new File(outputPath + File.separator
							+ entry.getName());
					f.getParentFile().mkdirs();
				}
				int count;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new FileOutputStream(outputPath
						+ File.separator + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);

				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}

				dest.flush();
				dest.close();
			}
			if (zis != null) {
				zis.closeEntry();
				zis.close();
			}

			// deleteFile为true,则删除文件
			if (deleteFile) {
				file.delete();
			}

			long time = System.currentTimeMillis() - startTime;
			System.out.print("解压完成:" + filePath + ",耗时" + time + "ms");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		Zip.extZipFileList("c:\\aa.zip", "c:\\");
	}
}
