package com.macw.wwdoc.util;

import com.macw.wwdoc.service.IQiniuUploadFileService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

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



}
