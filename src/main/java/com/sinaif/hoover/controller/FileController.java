package com.sinaif.hoover.controller;

import com.sinaif.hoover.utils.ApiException;
import com.sinaif.hoover.utils.BaiChuanMedia;
import com.sinaif.hoover.utils.IdGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/file")
public class FileController {

//	@RequestMapping("/upload")
//	@ResponseBody
//	public String fileUpload() {
//		System.out.println( "---------------------------" );
//
//		String dateStr = new Date().getTime()+"";
//
//		File file = new File( "C:\\Users\\dell\\Desktop\\sdfgsdf.jpg" );
//		String filePath = BaiChuanMedia.upload(  file, "load/20180629", dateStr + "testaaa.png" );
//		return "Hello -----World!" + filePath;
//	}

	@RequestMapping("/uploads")
	@ResponseBody
	public Map<String,Object> fileUploadmultiple(MultipartFile file)  {
		// 判断文件是否空
		Map<String,Object> result = new HashMap <String,Object>(  );
		if (file == null || file.isEmpty()) {
			result.put( "code", "500");
			result.put( "msg", "图片为空！");
			return  result;
		}
		String name = IdGenerator.getId()+file.getOriginalFilename();
//		String tempName = "tmp"+file.getOriginalFilename();

		Long  size = file.getSize();
		if(size < 1024 || size > 2048*1024 ){
			result.put( "code", "500");
			result.put( "msg", "图片大小超出！");
			return  result;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
		String dateStr = sdf.format( new Date() );

		File f = null;
		String filePath = null;
		try {
//			f=File.createTempFile(System.nanoTime()+"", name.substring( name.lastIndexOf( "." ) ));
			f=File.createTempFile("temp", null); //创建临时文件
			file.transferTo(f);//转存文件

			filePath = BaiChuanMedia.upload(  f, "load/"+dateStr, name );

			result.put( "code", "200");
		} catch (IOException e) {
			e.printStackTrace();
			result.put( "code", "500");
			result.put( "msg", "服务器异常");
		}finally {
			if(f.exists()){
				f.delete();
			}
		}
		Map<String,String> data = new HashMap <String,String>(  );
		data.put( "url", filePath);
		data.put( "delete", "");

		result.put( "data", data);

		return  result;
	}


}
