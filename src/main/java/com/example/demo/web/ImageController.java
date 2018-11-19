package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.froala.editor.Image;
import com.google.gson.Gson;

@RestController
public class ImageController {

	    @PostMapping(name = "upload", value="/upload")
	    public String  upload_image(@RequestParam("file")Part file,
//	    		@RequestParam("image_param")String param,
	    		HttpServletRequest mrequest){
	    	System.out.println("file:"+file.getSubmittedFileName());
	        System.out.println("request:"+mrequest.getContentType());
	        String fileRoute = "/upload/";
			Map<Object, Object> responseData;
			try {
				responseData = Image.upload(mrequest, fileRoute); // Use default// image// validation.						
			} catch (Exception e) {
				e.printStackTrace();
				responseData = new HashMap<Object, Object>();
				responseData.put("error", e.toString());
			}
			String jsonResponseData = new Gson().toJson(responseData);
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			System.out.println("responseData:"+jsonResponseData); 
//		    response.getWriter().write(jsonResponseData);
			return jsonResponseData;
	    }
	    
}
