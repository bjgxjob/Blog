package com.fpliu.blog.util;

import java.io.File;

import jodd.util.StringUtil;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * 
 * 使用jodconverter进行文档转换
 * 
 * @author 792793182@qq.com 2015-07-23
 *
 */
public final class DocConverter {

	private File originFile;

	private File pdfFile;

	private File swfFile;

	/**
	 * 初始化
	 * 
	 * @param filePath
	 *            要转化的文件路径
	 * @return 是否初始化成功
	 */
	private boolean init(String filePath) {
		if (!StringUtil.isEmpty(filePath)) {
			int index = filePath.indexOf('.');
			if (index > 0) {
				originFile = new File(filePath);
				if (originFile.exists() && originFile.isFile()) {
					String prefix = filePath.substring(0, index);
					pdfFile = new File(prefix + ".pdf");
					swfFile = new File(prefix + ".swf");
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 讲文档转成PDF文档
	 * @return 转换是否成功
	 */
	private boolean toPDF() {
		if (originFile.exists()) {
			if (!pdfFile.exists()) {
				OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
				try {
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
					converter.convert(originFile, pdfFile);
					connection.disconnect();
					System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath() + "****");
					return true;
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					System.out.println("****swf转换器异常，openoffice服务未启动！****");
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("****swf转换器异常，读取转换文件失败****");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("****已经转换为pdf，不需要再进行转化****");
			}
		} else {
			System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
		}
		return false;
	}
	
	
}
