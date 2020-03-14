package com.macw.wwdoc.util;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.macw.wwdoc.service.IQiniuUploadFileService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Administrator
 */
public class FileUploadUtil {

	@Resource
	private IQiniuUploadFileService iQiniuUploadFileService;

	public  String uploadFile(MultipartFile file) throws IOException {
		//multipartFile转File
		File attach = FileUploadUtil.multipartFileConverFile(file);
		String url = iQiniuUploadFileService.uploadFile(attach);
		//删除临时文件
		FileUploadUtil.delteTempFile(attach);
		return url;
	}

	public static File multipartFileConverFile(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String prefix=fileName.substring(fileName.lastIndexOf("."));
		// 用uuid作为文件名，防止生成的临时文件重复
		File excelFile = File.createTempFile(UUIDUtil.getUUID(), prefix);
		// MultipartFile to File
		file.transferTo(excelFile);

		return excelFile;

	}

	/**
	 * 删除本地临时文件
	 * @param file
	 */
	public static void delteTempFile(File file) {
		if (file != null) {
			File del = new File(file.toURI());
			del.delete();
		}
	}

	/**
	 * 导出word
	 * <p>第一步生成替换后的word文件，只支持docx</p>
	 * <p>第二步下载生成的文件</p>
	 * <p>第三步删除生成的临时文件</p>
	 * 模版变量中变量格式：{{foo}}
	 * @param templatePath word模板地址
	 * @param temDir 生成临时文件存放地址
	 * @param fileName 文件名
	 * @param params 替换的参数
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public static void exportWord(String templatePath, String temDir, String fileName, Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		Assert.notNull(templatePath,"模板路径不能为空");
		Assert.notNull(temDir,"临时文件路径不能为空");
		Assert.notNull(fileName,"导出文件名不能为空");
		Assert.isTrue(fileName.endsWith(".docx"),"word导出请使用docx格式");
		if (!temDir.endsWith("/")){
			temDir = temDir + File.separator;
		}
		File dir = new File(temDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			String userAgent = request.getHeader("user-agent").toLowerCase();
			if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
			}
			XWPFDocument doc = WordExportUtil.exportWord07(templatePath, params);
			String tmpPath = temDir + fileName;
			FileOutputStream fos = new FileOutputStream(tmpPath);
			doc.write(fos);
			// 设置强制下载不打开
			response.setContentType("application/force-download");
			// 设置文件名
			response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
			OutputStream out = response.getOutputStream();
			doc.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//这一步看具体需求，要不要删
			delteTempFile(dir);
		}

	}


}
