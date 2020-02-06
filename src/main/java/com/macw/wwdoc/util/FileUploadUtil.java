package com.macw.wwdoc.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtil {


	public static String baseUpload(MultipartFile file,String specifiedPath) throws IOException {
			String extName = file.getOriginalFilename();
			// 获取文件后缀
			if (extName.lastIndexOf(".") <= 0) {
				throw new RuntimeException("不支持该文件类型");
			}
			extName = extName.substring(extName.lastIndexOf("."));
			String fileName = getFileName();
			// 获取文件名字
			fileName = getFileName() + extName;
			File file2 = new File(specifiedPath);
			if (!file2.exists()) {
				file2.mkdirs();
			}
			file.transferTo(new File(specifiedPath + File.separator+ fileName));
			return "/"+fileName;
	}

	/**
	 * 获取文件名
	 * @return
	 */
	public static String getFileName() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid.toLowerCase();
	}

	/**
	 *
	 * @Title: getFileName
	 * @Description: (获得文件名称)
	 * @param file
	 * @return
	 * @date 2019年12月6日 下午5:48:20
	 * @author 马超伟
	 */
	public static String getFileName(MultipartFile file) {
		String extName = file.getOriginalFilename();
		// 获取文件后缀
		if (extName.lastIndexOf(".") <= 0) {
			throw new RuntimeException("不支持该文件类型");
		}
		extName = extName.substring(extName.lastIndexOf("."));
		// 获取文件名字
		return  getFileName() + extName;
	}

	
	public static String getWebUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return  request.getServletContext().getRealPath("/img");
	}
	
	public static String getWebProUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +request.getContextPath();
	}


	/**
	 *
	 * @Title: getFiledir
	 * @Description: (通过Id获得文件路径 如果没有则创建文件夹)
	 * @param path
	 * @param id
	 * @return
	 * @date 2019年12月9日 上午10:27:51
	 * @author 马超伟
	 */
	public static String getFiledir(String path,Integer id) {
		int temp = 1000;
		id= id%temp;
		return path+"/"+id+"/";

	}
	public static String getFiledir(String path) {
		return path+"/";

	}

	public static File MultipartFileConverFile(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String prefix=fileName.substring(fileName.lastIndexOf("."));
		// 用uuid作为文件名，防止生成的临时文件重复
		File excelFile = File.createTempFile(UUIDUtil.getUUID(), prefix);
		// MultipartFile to File
		file.transferTo(excelFile);
		return excelFile;

	}


}
