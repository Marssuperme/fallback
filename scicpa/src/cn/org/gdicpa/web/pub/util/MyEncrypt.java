package cn.org.gdicpa.web.pub.util;

import java.io.*;

public class MyEncrypt {
	public int getPwdBySeed(String sPwd) {
		int x, y, iRst = 0;
		char[] p;
		int[] iArr;
		String mPwd;

		if (sPwd == null || sPwd.length() < 1)
			return 0;
		p = sPwd.toCharArray();
		y = sPwd.length();
		iArr = new int[y];

		for (x = 1; x <= y; x++) {
			iArr[x - 1] = (int) (p[x - 1]) * 1974;
		}

		for (x = 0; x < y; x++) {
			// 第1和-1两数右移3位的高16位，2与-2两数右移2位的低16位组成新的int数32位
			iRst += (iArr[x] >> 3) + (iArr[y - 1 - x] >> 2);
		}

		return iRst;
	}

	public void decryptFile(String filePath, String sPwd) throws Exception {
		//1. 容错
		if (filePath == null || filePath.trim().equals("") || filePath.length() < 8)
			throw new Exception("文件名不能为空！");
		if (sPwd == null || sPwd.trim().equals(""))
			sPwd = "mtsoft";
		if (sPwd == null || sPwd.trim().equals(""))
			throw new Exception("种子不能为空！");
		if (!new File(filePath).exists())
			throw new Exception("文件不存在！");
		// 开始创建输入流
		int totalLen = 0;
		int size = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte[] data = new byte[4];
		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(new FileOutputStream(filePath + ".zip"));
		//2 验证密码
		bis.read(data);
		int iPwd = bytes2int2(data);
		if (iPwd != getPwdBySeed(sPwd)) {
			 throw new Exception("密码不对！");
			//System.out.println("密码不对！原密码=" + iPwd + "：新密码=" + getPwdBySeed(sPwd));
		}
		//3 取长度
		bis.read(data);
		int oldLen = bytes2int2(data);
		//System.out.println("数据长度="+oldLen);
		//4 读取前1024字节
		data = new byte[1024];
		size = bis.read(data);
		totalLen += size;
		//System.out.println(size+":"+totalLen);
		subtract1(data);
		bos.write(data);
		//5 读取余下数据，如果超过原来的长度，则去掉
		data = new byte[4096];
		size = bis.read(data);
		while (size != -1) {
			//totalLen += size;
			//System.out.println(size+":"+totalLen);
			bos.write(data);
			size = bis.read(data);
		}

		//System.out.println("实际长度="+totalLen);

		if (bis != null) {
			bis.close();
		}
		if (bos != null) {
			bos.flush();
			bos.close();
		}
	}
	
	/**
	 * 对应mt3的文件解密
	 * @param filePath
	 * @param sPwd
	 * @throws Exception
	 */
	public void decryptFile3(String filePath, String sPwd) throws Exception {
		//1. 容错
		if (filePath == null || filePath.trim().equals("") || filePath.length() < 8)
			throw new Exception("文件名不能为空！");
		if (sPwd == null || sPwd.trim().equals(""))
			sPwd = "mtsoft";
		if (sPwd == null || sPwd.trim().equals(""))
			throw new Exception("种子不能为空！");
		if (!new File(filePath).exists())
			throw new Exception("文件不存在！");
		// 开始创建输入流
		int totalLen = 0;
		int size = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte[] data = new byte[4];
		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(new FileOutputStream(filePath + ".zip"));
		//2 验证密码
		bis.read(data);
		int iPwd = bytes2int2(data);
		if (iPwd != getPwdBySeed(sPwd)) {
			 throw new Exception("密码不对！");
			//System.out.println("密码不对！原密码=" + iPwd + "：新密码=" + getPwdBySeed(sPwd));
		}
		//3 取长度
		//bis.read(data);
		//int oldLen = bytes2int2(data);
		//System.out.println("数据长度="+oldLen);
		//4 读取前1024字节
		//data = new byte[1024];
		//size = bis.read(data);
		//totalLen += size;
		//System.out.println(size+":"+totalLen);
		//subtract1(data);
		//bos.write(data);
		//5 读取余下数据，如果超过原来的长度，则去掉
		data = new byte[4096];
		size = bis.read(data);
		while (size != -1) {
			//totalLen += size;
			//System.out.println(size+":"+totalLen);
			
			subtract1(data);
			
			bos.write(data);
			size = bis.read(data);
		}

		//System.out.println("实际长度="+totalLen);

		if (bis != null) {
			bis.close();
		}
		if (bos != null) {
			bos.flush();
			bos.close();
		}
	}
	
	public void decryptFile(String filePath, String sPwd,int iHeadLength) throws Exception {
		//1. 容错
		if (filePath == null || filePath.trim().equals("") || filePath.length() < 8)
			throw new Exception("文件名不能为空！");
		if (sPwd == null || sPwd.trim().equals(""))
			sPwd = "mtsoft";
		if (sPwd == null || sPwd.trim().equals(""))
			throw new Exception("种子不能为空！");
		if (!new File(filePath).exists())
			throw new Exception("文件不存在！");
		// 开始创建输入流
		int totalLen = 0;
		int size = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte[] data = new byte[4];
		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(new FileOutputStream(filePath + ".zip"));
		//2 验证密码
		bis.read(data);
		int iPwd = bytes2int2(data);
		if (iPwd != getPwdBySeed(sPwd)) {
			 throw new Exception("密码不对！");
			//System.out.println("密码不对！原密码=" + iPwd + "：新密码=" + getPwdBySeed(sPwd));
		}
		//3 取长度
		bis.read(data);
		int oldLen = bytes2int2(data);
		//System.out.println("数据长度="+oldLen);
		
		//4 读取前iHeadLength字节
		data = new byte[iHeadLength];
		size = bis.read(data);
		totalLen += size;
		//System.out.println(size+":"+totalLen);
		subtract1(data);
		bos.write(data);
		//5 读取余下数据，如果超过原来的长度，则去掉
		data = new byte[4096];
		size = bis.read(data);
		while (size != -1) {
			//totalLen += size;
			//System.out.println(size+":"+totalLen);
			bos.write(data);
			size = bis.read(data);
		}

		//System.out.println("实际长度="+totalLen);

		if (bis != null) {
			bis.close();
		}
		if (bos != null) {
			bos.flush();
			bos.close();
		}
	}
	

	public void _get(String filePath) throws Exception {
		BufferedInputStream bis = null;
		byte[] data = new byte[4096];
		bis = new BufferedInputStream(new FileInputStream(filePath));
		int size = 0,totalLen = 0;
		while (size != -1) {
			size = bis.read(data);
			totalLen += size;
			if(totalLen > 971060) {
				System.out.println("size="+size);
				System.out.println(data[size-1]);
				System.out.println(data[size-2]);
				System.out.println(data[size-3]);
				System.out.println(data[size-4]);
				System.out.println(data[size-5]);
			}
		}
		//System.out.println("实际长度="+totalLen);
		if (bis != null) {
			bis.close();
		}
	}

	private byte[] additive(int len) {
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[i] = 0;
		}
		return b;
	}

	private byte[] skim(byte[] data, int len) {
		if(data==null) return null;
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[i] = data[i];
		}
		return b;
	}

	private int bytes2int2(byte[] input) {
		return ((input[0] << 0) & 0x000000FF) | (((input[1]) << 8) & 0x0000FF00)
				| (((input[2]) << 16) & 0x00FF0000) | (((input[3] << 24) & 0xff000000));
	}

	//反了，没用
	int bytes2int(byte[] b) {
		// byte[] b=new byte[]{1,2,3,4};
		int mask = 0xff;
		int temp = 0;
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res <<= 8;
			temp = b[i] & mask;
			res |= temp;
		}
		return res;
	}

	////反了，没用
	byte[] int2bytes(int num) {
		byte[] b = new byte[4];
		int mask = 0xff;
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (num >>> (24 - i * 8));
		}
		return b;
	}

	public static int b2i(byte b) {
		return b < 0 ? b & 0x7F + 128 : b;
	}

	private void subtract1(byte[] data) {
		if (data == null)
			return;
		for (int i = 0; i < data.length; i++) {
			data[i] -= 1;
			//if(i<2) //System.out.println((char)data[i]);
		}
	}

	/**
	 * 从from数组拷贝到to数组，to从offset开始
	 *
	 * @param from
	 * @param to
	 * @param offset
	 * @return
	 */
	public static void copyTo(byte[] from, byte[] to, int offset)
			throws Exception {
		if (to.length - offset < from.length)
			throw new Exception("to数组长度太小！");
		for (int i = 0; i < from.length; i++) {
			to[offset + i] = from[i];
		}
	}

}
